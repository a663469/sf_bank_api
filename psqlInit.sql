drop schema bank;
DROP TABLE bank.accounts;

create schema bank;

CREATE TABLE bank.accounts (
  id serial8  NOT NULL PRIMARY KEY,
  balance float8 NOT NULL
);

INSERT into bank.accounts (balance) values (1001);
INSERT into bank.accounts (balance) values (999);
INSERT into bank.accounts (balance) values (0);
INSERT into bank.accounts (balance) values (-15);