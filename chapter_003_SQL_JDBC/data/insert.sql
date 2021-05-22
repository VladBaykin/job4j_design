insert into role(name) values ('admin');
insert into category(name) values ('high priority');
insert into state(name) values ('in progress');
insert into users(name, role_id) values ('name', 1);
insert into rules(name) values ('major');
insert into role_rules(role_id, rules_id) values (1, 1);
insert into item(name, users_id, category_id,state_id) values ('first', 1, 1, 1);
insert into comments(name, item_id) values ('comment', 1);
insert into attachs(name, item_id) values ('file', 1);