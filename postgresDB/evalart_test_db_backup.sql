--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2 (Debian 16.2-1.pgdg120+2)
-- Dumped by pg_dump version 16.2 (Debian 16.2-1.pgdg120+2)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: product; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.product (
    id bigint NOT NULL,
    name text NOT NULL
);


ALTER TABLE public.product OWNER TO "user";

--
-- Name: product_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

ALTER TABLE public.product ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: stock; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.stock (
    id bigint NOT NULL,
    product_id bigint NOT NULL,
    subsidiary_branch_id bigint NOT NULL,
    stock bigint
);


ALTER TABLE public.stock OWNER TO "user";

--
-- Name: stock_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

ALTER TABLE public.stock ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.stock_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: subsidiary; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.subsidiary (
    id bigint NOT NULL,
    name text NOT NULL
);


ALTER TABLE public.subsidiary OWNER TO "user";

--
-- Name: subsidiary_branch; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.subsidiary_branch (
    id bigint NOT NULL,
    name text NOT NULL,
    subsidiary_id bigint NOT NULL
);


ALTER TABLE public.subsidiary_branch OWNER TO "user";

--
-- Name: subsidiary_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

ALTER TABLE public.subsidiary_branch ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.subsidiary_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: subsidiary_id_seq1; Type: SEQUENCE; Schema: public; Owner: user
--

ALTER TABLE public.subsidiary ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.subsidiary_id_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.product (id, name) FROM stdin;
1	milk
2	cheese
3	hot dog
5	kebab
\.


--
-- Data for Name: stock; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.stock (id, product_id, subsidiary_branch_id, stock) FROM stdin;
5	5	3	148
4	3	1	20
6	2	3	20
7	3	4	100
\.


--
-- Data for Name: subsidiary; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.subsidiary (id, name) FROM stdin;
1	smart maket
2	mc burger
\.


--
-- Data for Name: subsidiary_branch; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.subsidiary_branch (id, name, subsidiary_id) FROM stdin;
1	ohio	1
2	bogota	2
3	medellin	2
4	madrid	2
6	manhathan	1
7	gothic city	1
5	Telaviv	1
\.


--
-- Name: product_id_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.product_id_seq', 5, true);


--
-- Name: stock_id_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.stock_id_seq', 7, true);


--
-- Name: subsidiary_id_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.subsidiary_id_seq', 7, true);


--
-- Name: subsidiary_id_seq1; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.subsidiary_id_seq1', 2, true);


--
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- Name: stock stock_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.stock
    ADD CONSTRAINT stock_pkey PRIMARY KEY (id);


--
-- Name: subsidiary_branch subsidiary_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.subsidiary_branch
    ADD CONSTRAINT subsidiary_pkey PRIMARY KEY (id);


--
-- Name: subsidiary subsidiary_pkey1; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.subsidiary
    ADD CONSTRAINT subsidiary_pkey1 PRIMARY KEY (id);


--
-- Name: stock stock_product_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.stock
    ADD CONSTRAINT stock_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.product(id);


--
-- Name: stock stock_subsidiary_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.stock
    ADD CONSTRAINT stock_subsidiary_id_fkey FOREIGN KEY (subsidiary_branch_id) REFERENCES public.subsidiary_branch(id);


--
-- Name: subsidiary_branch subsidiary_branch_subsidiary_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.subsidiary_branch
    ADD CONSTRAINT subsidiary_branch_subsidiary_id_fkey FOREIGN KEY (subsidiary_id) REFERENCES public.subsidiary(id) NOT VALID;


--
-- PostgreSQL database dump complete
--

