
INSERT INTO USERS (id, username, password, name, email, enabled, last_password_reset_date) VALUES
(1, 'admin', '$2a$10$zuI3P8hoZNkFGR2dDPW9juA1C1xIHBUNrKMGqjjaEKsLTwjJkKoNa', 'Admin', 'admin@gmail.com', true, CURRENT_TIMESTAMP),
(2, 'siva', '$2a$10$LskLrNP6m.dEpXYjT41lRePseXJEjhd6.sPH2Z5GbbShtaFRWoeYq', 'Siva', 'siva@gmail.com', true, CURRENT_TIMESTAMP);

INSERT INTO ROLES (id, name) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

INSERT INTO USER_ROLE (user_id, role_id) VALUES
(1, 1),
(2, 1),
(2, 2);
