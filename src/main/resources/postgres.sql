drop table if exists user_details;
create table IF NOT EXISTS user_details (
email VARCHAR,
name VARCHAR,
credit_limit FLOAT,
outstanding_balance FLOAT,
onboard_on TIMESTAMP DEFAULT now(),
PRIMARY KEY (email),
UNIQUE(name)
);

drop table if exists merchant;
create table IF NOT EXISTS merchant (
email VARCHAR,
name VARCHAR,
discount_percent FLOAT,
discount_provided FLOAT,
onboard_on TIMESTAMP DEFAULT now(),
PRIMARY KEY (email),
UNIQUE(name)
);

drop table if exists transaction;
create table IF NOT EXISTS transaction (
id BIGINT,
user_name VARCHAR,
merchant VARCHAR,
amount FLOAT,
discount FLOAT,
decision VARCHAR,
created_on TIMESTAMP DEFAULT now(),
PRIMARY KEY (id)
);
