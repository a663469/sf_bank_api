DROP TABLE bank.operations;
DROP TABLE bank.accounts;
DROP SCHEMA bank;

create schema bank;

CREATE TABLE bank.accounts
(
    id      serial8 NOT NULL PRIMARY KEY,
    balance float8  NOT NULL
);

CREATE TABLE bank.operations
(
    id         serial8 NOT NULL PRIMARY KEY,
    account_id serial8,
--     operation_type int     NOT NULL,
    amount     float8,
    date       date,
    time       time,
    status     bool,
    opr_type    varchar,
    message    varchar,
    FOREIGN KEY (account_id) REFERENCES bank.accounts (id)
);

INSERT into bank.accounts (balance)
values (1001);
INSERT into bank.accounts (balance)
values (999);
INSERT into bank.accounts (balance)
values (0);
INSERT into bank.accounts (balance)
values (-15);

-- INSERT into bank.operations (amount)
-- values (200);
-- INSERT into bank.operations (amount)
-- values (400);
-- INSERT into bank.operations (amount)
-- values (600);
-- INSERT into bank.operations (amount)
-- values (800);