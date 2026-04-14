--
-- PostgreSQL database dump
--

\restrict geoUmm2WWWDrRPhbzSJZegiO53fJ7Lz79Al5ZNR88YHymCVE8dUf3X2ghG9OCb0

-- Dumped from database version 16.13 (Ubuntu 16.13-0ubuntu0.24.04.1)
-- Dumped by pg_dump version 16.13 (Ubuntu 16.13-0ubuntu0.24.04.1)

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

ALTER TABLE ONLY public.suplemento DROP CONSTRAINT suplemento_pkey;
ALTER TABLE public.suplemento ALTER COLUMN id DROP DEFAULT;
DROP SEQUENCE public.suplemento_id_seq;
DROP TABLE public.suplemento;
SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: suplemento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.suplemento (
    id bigint NOT NULL,
    dosis character varying(50) NOT NULL,
    laboratorio character varying(50) NOT NULL,
    nombre character varying(50) NOT NULL,
    precio double precision NOT NULL,
    presentacion character varying(50) NOT NULL,
    stock integer NOT NULL
);


ALTER TABLE public.suplemento OWNER TO postgres;

--
-- Name: suplemento_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.suplemento_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.suplemento_id_seq OWNER TO postgres;

--
-- Name: suplemento_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.suplemento_id_seq OWNED BY public.suplemento.id;


--
-- Name: suplemento id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.suplemento ALTER COLUMN id SET DEFAULT nextval('public.suplemento_id_seq'::regclass);


--
-- Data for Name: suplemento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.suplemento VALUES (1, '5mg al dia disuelto en agua', 'God''s nutrition', 'Creatina', 35.5, 'Polvo', 10);
INSERT INTO public.suplemento VALUES (8, '1 capsula en las noches', 'Mason Natural', 'Omega 3', 39, 'Capsulas 1000mg', 5);
INSERT INTO public.suplemento VALUES (6, '1 capsula diaria con el desayuno', 'Xtralife', 'L-Arginina', 19.95, 'Capsulas de 60mg', 7);
INSERT INTO public.suplemento VALUES (7, 'De acuerdo al plan alimenticio individual', 'Megalabs', 'Proteina Whey', 116.45, 'Polvo', 3);


--
-- Name: suplemento_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.suplemento_id_seq', 8, true);


--
-- Name: suplemento suplemento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.suplemento
    ADD CONSTRAINT suplemento_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

\unrestrict geoUmm2WWWDrRPhbzSJZegiO53fJ7Lz79Al5ZNR88YHymCVE8dUf3X2ghG9OCb0

