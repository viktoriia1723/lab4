CREATE TABLE IF NOT EXISTS books (
    id       SERIAL PRIMARY KEY,
    type     VARCHAR(20)      NOT NULL,
    title    VARCHAR(255)     NOT NULL,
    author   VARCHAR(255)     NOT NULL,
    pages    INTEGER          NOT NULL,
    price    DOUBLE PRECISION NOT NULL,
    genre    VARCHAR(50)      NOT NULL,
    extra1   VARCHAR(255),
    extra2   VARCHAR(255)
);