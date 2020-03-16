create table if not exists account
(
    id    serial not null
        constraint account_pkey
            primary key,
    name  varchar(200),
    phone varchar(200)
);

INSERT INTO public.account (id, name, phone) VALUES (-1, 'default row', '1111');

create table if not exists hall
(
    id         serial not null
        constraint hall_pkey
            primary key,
    row        smallint,
    seat       smallint,
    status     boolean default true,
    account_id integer
        constraint hall_fk
            references account
);

INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (69, 3, 4, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (73, 3, 8, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (55, 1, 6, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (70, 3, 5, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (66, 3, 1, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (113, 8, 8, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (112, 8, 7, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (72, 3, 7, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (107, 8, 2, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (52, 1, 3, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (50, 1, 1, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (51, 1, 2, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (89, 5, 8, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (88, 5, 7, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (84, 5, 3, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (108, 8, 3, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (103, 7, 6, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (53, 1, 4, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (54, 1, 5, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (106, 8, 1, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (85, 5, 4, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (62, 2, 5, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (64, 2, 7, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (102, 7, 5, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (79, 4, 6, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (68, 3, 3, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (56, 1, 7, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (57, 1, 8, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (61, 2, 4, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (86, 5, 5, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (87, 5, 6, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (74, 4, 1, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (91, 6, 2, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (67, 3, 2, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (93, 6, 4, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (81, 4, 8, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (95, 6, 6, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (80, 4, 7, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (82, 5, 1, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (83, 5, 2, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (90, 6, 1, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (105, 7, 8, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (97, 6, 8, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (110, 8, 5, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (109, 8, 4, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (101, 7, 4, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (60, 2, 3, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (111, 8, 6, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (98, 7, 1, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (100, 7, 3, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (71, 3, 6, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (75, 4, 2, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (65, 2, 8, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (59, 2, 2, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (94, 6, 5, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (76, 4, 3, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (96, 6, 7, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (104, 7, 7, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (63, 2, 6, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (58, 2, 1, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (92, 6, 3, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (99, 7, 2, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (77, 4, 4, true, -1);
INSERT INTO public.hall (id, row, seat, status, account_id) VALUES (78, 4, 5, true, -1);

