DROP TABLE bank.operations;
DROP TABLE bank.accounts;
DROP SCHEMA bank;

create schema bank;

CREATE TABLE bank.accounts
(
    id      serial8 NOT NULL PRIMARY KEY,
    balance float8  NOT NULL,
    booking float8  NOT NULL
);

CREATE TABLE bank.operations
(
    id         serial8 NOT NULL PRIMARY KEY,
    account_id serial8,
    amount     float8,
    date       date,
    time       time,
    status     bool,
    opr_type    varchar,
    message    varchar,
    FOREIGN KEY (account_id) REFERENCES bank.accounts (id)
);

INSERT into bank.accounts (balance, booking)
values (1001, 0);
INSERT into bank.accounts (balance, booking)
values (999, 0);
INSERT into bank.accounts (balance, booking)
values (0, 0);
INSERT into bank.accounts (balance, booking)
values (-15, 0);

-- INSERT into bank.operations (amount)
-- values (200);
-- INSERT into bank.operations (amount)
-- values (400);
-- INSERT into bank.operations (amount)
-- values (600);
-- INSERT into bank.operations (amount)
-- values (800);