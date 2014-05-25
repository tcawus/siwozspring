INSERT INTO Users (name, surname, username, pesel, password) VALUES ('John', 'Doe', 'example@example.com', '1234567890', '12345');
INSERT INTO Users (name, surname, username, pesel, password) VALUES ('Jan', 'Nowak', 'jan.nowak@gmail.com', '1949461561', '12345');
INSERT INTO Users (name, surname, username, pesel, password) VALUES ('Tomasz', 'Kowalski', 't.kowalski@gmail.com', '1549461561', '12345');
INSERT INTO Users (name, surname, username, pesel, password) VALUES ('Robert','Kwiatkowski', 'r.k@gmail.com', '1149461561', '12345');

INSERT INTO user_roles (username, ROLE)
VALUES ('example@example.com', 'ROLE_USER');
INSERT INTO user_roles (username, ROLE)
VALUES ('t.kowalski@gmail.com', 'ROLE_ADMIN');
