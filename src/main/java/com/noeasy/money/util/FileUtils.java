/*
 * This code is provided solely for the use of the licensee subject to the terms
 * and conditions of the Master Service Agreement. Redistribution and use in
 * source and binary forms, with or without modification, are prohibited.
 * 
 * DISCLAIMER.THIS SOFTWARE IS PROVIDED BY AAXIS GROUP CORPORATION "AS IS."
 * EXCEPT AS SPECIFICALLY SET FORTH IN THE MASTER SERVICES AGREEMENT, ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS, AND WARRANTIES INCLUDING,
 * WITHOUT LIMITATION, ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, NONINFRINGEMENT OR ARISING FROM A COURSE OF DEALING,
 * USAGE, OR TRADE PRACTICE, ARE HEREBY EXCLUDED TO THE EXTENT ALLOWED BY
 * APPLICABLE LAW.
 * 
 * IN NO EVENT WILL AAXIS GROUP CORPORATION, THE COPYRIGHT OWNER OR CONTRIBUTORS
 * BE LIABLE FOR ANY LOST REVENUE, PROFIT, OR DATA, OR FOR SPECIAL, INDIRECT,
 * CONSEQUENTIAL, INCIDENTAL, EXEMPLARY OR PUNITIVE DAMAGESINCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND REGARDLESS OF THE
 * THEORY OF LIABILITY ARISING OUT OF THE USE OF OR INABILITY TO USE THE
 * SOFTWARE EVEN IF AAXIS GROUP CORPORATION HAS BEEN ADVISED OF THE POSSIBILITY
 * OF SUCH DAMAGES.
 * 
 * IN NO EVENT SHALL AAXIS GROUP CORPORATION'S LIABILITY TO THE CUSTOMER OR USER
 * OF THIS SOFTWARE, WHETHER IN CONTRACT, TORT (INCLUDING NEGLIGENCE), OR
 * OTHERWISE, EXCEED THE PRICE PAID BY THE CUSTOMER OR USER FOR THIS SOFTWARE.
 * THE FOREGOING LIMITATIONS SHALL APPLY EVEN IF THE ANY WARRANTY PROVIDED IN
 * THE MASTER SERVICE AGREEMENT FAILS OF ITS ESSENTIAL PURPOSE.
 */
package com.noeasy.money.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Feb 22, 2014
 */

public class FileUtils {

    public static final String  CONFIG_UPLOAD_BASE_FOLDER = "uploadBaseFolder";
    public static final String  CONFIG_IMAGE_FOLDER       = "imageFolder";
    public static final String  CONFIG_VIDEO_FOLDER       = "videoFolder";
    public static final String  CONFIG_DORMITORY          = "dormitoryFolder";
    public static final String  CONFIG_SLIDE              = "slideFolder";
    public static final String  CONFIG_ARTICLE_COVER      = "articleCoverFolder";

    private static final String CONFIG_PATH               = "/config/upload/upload.properties";
    private static final String PARENT_PATH               = "../";
    public static final String  SLASH                     = "/";

    private static FileUtils    instance;

    static {
        instance = new FileUtils();
    }



    public static FileUtils getInstance() {
        return instance;
    }



    private FileUtils() {

    }



    public String createArticleCoverFolder(final Integer pArticleId) {
        return createFolder(getUploadArticleCoverPaht(), pArticleId.toString());
    }



    public String createFolder(final String pFilePath) {
        File filePath = new File(pFilePath + SLASH);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        return filePath.getAbsolutePath();
    }



    public String createFolder(final String pFilePath, final String pFolderName) {
        File filePath = new File(pFilePath + SLASH + pFolderName + SLASH);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        return filePath.getAbsolutePath();
    }



    public String createUploadDormitoryImageFolder(final Integer pDormitoryId) {
        return createFolder(getUploadDormitoryImagePaht(), pDormitoryId.toString());
    }



    public String createUploadSlideImageFolder() {
        return createFolder(getUploadSlideImagePaht());
    }



    public String generateRandomFileName(final String pOriginalFileName) {
        String extenseName = pOriginalFileName.substring(pOriginalFileName.lastIndexOf("."));
        return System.currentTimeMillis() + extenseName;
    }



    private String getConfigurableProperty(final String pKey) {
        return PropertiesUtils.getConfigurableProperty(CONFIG_PATH, pKey);
    }



    public File getFile(final String pFilePath, final String pFileName) {
        File filePath = new File(pFilePath);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        if (filePath.isDirectory()) {
            File[] files = filePath.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(final File pDir, final String pName) {
                    return pName.equals(pFileName);
                }
            });
            if (ArrayUtils.isNotEmpty(files)) {
                return files[0];
            }
        }
        return null;
    }



    public String getProjectBasePath() {
        return Thread.currentThread().getContextClassLoader().getResource(PARENT_PATH + PARENT_PATH).getPath();
    }



    public String getUploadArticleCoverPaht() {
        return getUploadImagePath() + SLASH + getConfigurableProperty(CONFIG_ARTICLE_COVER);
    }



    public String getUploadDormitoryImagePaht() {
        return getUploadImagePath() + SLASH + getConfigurableProperty(CONFIG_DORMITORY);
    }



    public String getUploadFolderPath() {
        return getProjectBasePath() + getConfigurableProperty(CONFIG_UPLOAD_BASE_FOLDER);
    }



    public String getUploadImagePath() {
        return getUploadFolderPath() + SLASH + getConfigurableProperty(CONFIG_IMAGE_FOLDER);
    }



    public String getUploadSlideImagePaht() {
        return getUploadImagePath() + SLASH + getConfigurableProperty(CONFIG_SLIDE);
    }



    public String getUploadVideoPath() {
        return getUploadFolderPath() + SLASH + getConfigurableProperty(CONFIG_VIDEO_FOLDER);
    }



    public void removeInvalidFiles(final String pFilePath, final List<String> pValidFileNames) {
        File filePath = new File(pFilePath);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        if (filePath.isDirectory()) {
            File[] files = filePath.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(final File pDir, final String pName) {
                    return !pValidFileNames.contains(pName);
                }
            });
            if (ArrayUtils.isNotEmpty(files)) {
                for (File file : files) {
                    file.delete();
                }
            }
        }
    }
}
