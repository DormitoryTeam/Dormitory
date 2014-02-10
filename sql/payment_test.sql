-- test Order

INSERT INTO `order` (user_id, belongs_to, type, status, amount, currency, create_time, update_time)
VALUES (1, 1, 'PICKUP', 'REVIEWDE', 60.0, 'CNY', NOW(), NOW());