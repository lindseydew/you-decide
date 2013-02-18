# Tasks schema

# --- !Ups

CREATE SEQUENCE click_rate_id_seq;
CREATE TABLE click_rate (
    id integer NOT NULL DEFAULT nextval('task_id_seq'),
    url_id integer,
    no_of_clicks integer
);

# --- !Downs

DROP TABLE click_rate;
DROP SEQUENCE click_rate_id_seq;