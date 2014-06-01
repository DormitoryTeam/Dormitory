alter table `order` add column send_save_email int(1) DEFAULT 0;
alter table `order` add column send_commit_email int(1) DEFAULT 0;