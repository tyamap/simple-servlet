USE `test_db`;

INSERT INTO `test_table`
    (`name`)
VALUES
    ('test'),
    ('hoge'),
    ('fuga'),
    ('foo'),
    ('bar');

INSERT INTO `test_employees`
    (`name`, `department`, `salary`)
VALUES
    ("Karan", "IT", 5000),
    ("Tommy", "IT", 3000),
    ("Jackson", "HR", 4000);

INSERT INTO `test_events`
    (`title`, `event_date`, `employee_id`)
VALUES
    ('test', '2020-09-01 17:50:00.0', 1),
    ('hoge', '2020-09-02 17:51:00.0', 1),
    ('fuga', '2020-09-03 17:52:00.0', 2),
    ('foo', '2020-09-04 17:53:00.0', 2),
    ('bar', '2020-09-05 17:54:00.0', 2);
