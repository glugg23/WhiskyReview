ALTER TABLE regions
    ADD UNIQUE (name);

ALTER TABLE distilleries
    ADD UNIQUE (name);

ALTER TABLE types
    ADD UNIQUE (name);

ALTER TABLE countries
    ADD UNIQUE (name);

ALTER TABLE reviewers
    ADD UNIQUE (name);

ALTER TABLE tasting_types
    ADD UNIQUE (type);
