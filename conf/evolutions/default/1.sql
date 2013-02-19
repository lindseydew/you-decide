# Tasks schema

# --- !Ups

CREATE TABLE click_rate (
    id integer,
    no_of_clicks integer
);

INSERT INTO click_rate(id, no_of_clicks) VALUES (1, 0);
INSERT INTO click_rate(id, no_of_clicks) VALUES (2, 0);
INSERT INTO click_rate(id, no_of_clicks) VALUES (3, 0);
INSERT INTO click_rate(id, no_of_clicks) VALUES (4, 0);
INSERT INTO click_rate(id, no_of_clicks) VALUES (5, 0);
INSERT INTO click_rate(id, no_of_clicks) VALUES (6, 0);
INSERT INTO click_rate(id, no_of_clicks) VALUES (7, 0);
INSERT INTO click_rate(id, no_of_clicks) VALUES (8, 0);
INSERT INTO click_rate(id, no_of_clicks) VALUES (9, 0);
INSERT INTO click_rate(id, no_of_clicks) VALUES (10, 0);

CREATE TABLE experiment (
    started boolean not null default false
);
INSERT INTO experiment(started) VALUES (false);
# --- !Downs

DROP TABLE click_rate;
DROP TABLE experiment;