PRAGMA foreign_keys = ON;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS rent;
DROP TABLE IF EXISTS user;

CREATE TABLE IF NOT EXISTS book (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name TEXT NOT NULL,
  author TEXT NOT NULL,
  description TEXT,
  total INTEGER NOT NULL DEFAULT 0,
  amount INTEGER NOT NULL DEFAULT 0,
  image TEXT
);

CREATE TABLE IF NOT EXISTS rent (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  user_id INTEGER NOT NULL,
  book_id INTEGER NOT NULL,
  rent_date INTEGER DEFAULT NULL,
  return_date INTEGER DEFAULT NULL,
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (book_id) REFERENCES book(id)
);

CREATE TABLE IF NOT EXISTS user (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name VARCHAR(50) NOT NULL,
  email TEXT NOT NULL UNIQUE,
  password TEXT NOT NULL,
  age INTEGER NOT NULL,
  role_id INTEGER NOT NULL DEFAULT 0
);

INSERT INTO user VALUES (1, 'cuong', 'admin@gmail.com', 'password',22,1);