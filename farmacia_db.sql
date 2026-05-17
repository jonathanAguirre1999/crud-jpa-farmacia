--
-- PostgreSQL database dump
--

\restrict uI3m6zhgL9DlnxvRe7kb0PEDXeWInhoW4Ps4ZQ7hSfpDaQLJvWufylWGFD9MAKp

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

ALTER TABLE IF EXISTS ONLY public.suplemento DROP CONSTRAINT IF EXISTS fkos08erifw4wiqhag5x5b7kw1f;
ALTER TABLE IF EXISTS ONLY public.suplemento_ingrediente DROP CONSTRAINT IF EXISTS fkfn6aqq5k0mr8417745uj2wvsb;
ALTER TABLE IF EXISTS ONLY public.suplemento DROP CONSTRAINT IF EXISTS fkf8ayr3ektjgghjprmu1fpb8e8;
ALTER TABLE IF EXISTS ONLY public.suplemento_ingrediente DROP CONSTRAINT IF EXISTS fkesnn7352d4pyxgbvtttsroyk1;
ALTER TABLE IF EXISTS ONLY public.suplemento DROP CONSTRAINT IF EXISTS fk5tnaygd8fincpe3u66op9pxpu;
ALTER TABLE IF EXISTS ONLY public.suplemento DROP CONSTRAINT IF EXISTS uk_apj9p3oady919id6wu558mir2;
ALTER TABLE IF EXISTS ONLY public.suplemento DROP CONSTRAINT IF EXISTS suplemento_pkey;
ALTER TABLE IF EXISTS ONLY public.laboratorio DROP CONSTRAINT IF EXISTS laboratorio_pkey;
ALTER TABLE IF EXISTS ONLY public.ingrediente DROP CONSTRAINT IF EXISTS ingrediente_pkey;
ALTER TABLE IF EXISTS ONLY public.detalle_nutricional DROP CONSTRAINT IF EXISTS detalle_nutricional_pkey;
ALTER TABLE IF EXISTS ONLY public.categoria DROP CONSTRAINT IF EXISTS categoria_pkey;
ALTER TABLE IF EXISTS public.suplemento ALTER COLUMN id DROP DEFAULT;
ALTER TABLE IF EXISTS public.laboratorio ALTER COLUMN id DROP DEFAULT;
ALTER TABLE IF EXISTS public.ingrediente ALTER COLUMN id DROP DEFAULT;
ALTER TABLE IF EXISTS public.detalle_nutricional ALTER COLUMN id DROP DEFAULT;
ALTER TABLE IF EXISTS public.categoria ALTER COLUMN id DROP DEFAULT;
DROP TABLE IF EXISTS public.suplemento_ingrediente;
DROP SEQUENCE IF EXISTS public.suplemento_id_seq;
DROP TABLE IF EXISTS public.suplemento;
DROP SEQUENCE IF EXISTS public.laboratorio_id_seq;
DROP TABLE IF EXISTS public.laboratorio;
DROP SEQUENCE IF EXISTS public.ingrediente_id_seq;
DROP TABLE IF EXISTS public.ingrediente;
DROP SEQUENCE IF EXISTS public.detalle_nutricional_id_seq;
DROP TABLE IF EXISTS public.detalle_nutricional;
DROP SEQUENCE IF EXISTS public.categoria_id_seq;
DROP TABLE IF EXISTS public.categoria;
SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: categoria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categoria (
    id bigint NOT NULL,
    tipo_suplemento character varying(255)
);


ALTER TABLE public.categoria OWNER TO postgres;

--
-- Name: categoria_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categoria_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.categoria_id_seq OWNER TO postgres;

--
-- Name: categoria_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categoria_id_seq OWNED BY public.categoria.id;


--
-- Name: detalle_nutricional; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.detalle_nutricional (
    id bigint NOT NULL,
    calorias integer,
    tamanio_porcion character varying(50)
);


ALTER TABLE public.detalle_nutricional OWNER TO postgres;

--
-- Name: detalle_nutricional_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.detalle_nutricional_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.detalle_nutricional_id_seq OWNER TO postgres;

--
-- Name: detalle_nutricional_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.detalle_nutricional_id_seq OWNED BY public.detalle_nutricional.id;


--
-- Name: ingrediente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ingrediente (
    id bigint NOT NULL,
    nombre character varying(50) NOT NULL
);


ALTER TABLE public.ingrediente OWNER TO postgres;

--
-- Name: ingrediente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ingrediente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.ingrediente_id_seq OWNER TO postgres;

--
-- Name: ingrediente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ingrediente_id_seq OWNED BY public.ingrediente.id;


--
-- Name: laboratorio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.laboratorio (
    id bigint NOT NULL,
    nombre character varying(50) NOT NULL,
    pais character varying(255)
);


ALTER TABLE public.laboratorio OWNER TO postgres;

--
-- Name: laboratorio_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.laboratorio_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.laboratorio_id_seq OWNER TO postgres;

--
-- Name: laboratorio_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.laboratorio_id_seq OWNED BY public.laboratorio.id;


--
-- Name: suplemento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.suplemento (
    id bigint NOT NULL,
    dosis character varying(50) NOT NULL,
    nombre character varying(50) NOT NULL,
    precio double precision NOT NULL,
    presentacion character varying(50) NOT NULL,
    stock integer NOT NULL,
    categoria_id bigint,
    detalle_id bigint,
    laboratorio_id bigint
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
-- Name: suplemento_ingrediente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.suplemento_ingrediente (
    suplemento_id bigint NOT NULL,
    ingrediente_id bigint NOT NULL
);


ALTER TABLE public.suplemento_ingrediente OWNER TO postgres;

--
-- Name: categoria id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria ALTER COLUMN id SET DEFAULT nextval('public.categoria_id_seq'::regclass);


--
-- Name: detalle_nutricional id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalle_nutricional ALTER COLUMN id SET DEFAULT nextval('public.detalle_nutricional_id_seq'::regclass);


--
-- Name: ingrediente id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingrediente ALTER COLUMN id SET DEFAULT nextval('public.ingrediente_id_seq'::regclass);


--
-- Name: laboratorio id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.laboratorio ALTER COLUMN id SET DEFAULT nextval('public.laboratorio_id_seq'::regclass);


--
-- Name: suplemento id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.suplemento ALTER COLUMN id SET DEFAULT nextval('public.suplemento_id_seq'::regclass);


--
-- Data for Name: categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.categoria VALUES (1, 'Proteínas');
INSERT INTO public.categoria VALUES (2, 'Vitaminas y Omegas');
INSERT INTO public.categoria VALUES (3, 'Aminoácidos');
INSERT INTO public.categoria VALUES (4, 'Pre-entrenos');


--
-- Data for Name: detalle_nutricional; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.detalle_nutricional VALUES (1, 120, '1 Scoop (30g)');
INSERT INTO public.detalle_nutricional VALUES (2, 15, '2 Cápsulas');
INSERT INTO public.detalle_nutricional VALUES (3, 0, '1 Scoop (10g)');
INSERT INTO public.detalle_nutricional VALUES (4, 5, '1 Cápsula');
INSERT INTO public.detalle_nutricional VALUES (5, 0, '1 Scoop (5g)');
INSERT INTO public.detalle_nutricional VALUES (6, 130, '1 Scoop (32g)');


--
-- Data for Name: ingrediente; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.ingrediente VALUES (1, 'Proteína de Suero Aislada');
INSERT INTO public.ingrediente VALUES (2, 'Aceite de Pescado (EPA/DHA)');
INSERT INTO public.ingrediente VALUES (3, 'L-Arginina Pura');
INSERT INTO public.ingrediente VALUES (4, 'Cafeína Anhidra');
INSERT INTO public.ingrediente VALUES (5, 'Creatina Monohidratada');
INSERT INTO public.ingrediente VALUES (6, 'Zinc');
INSERT INTO public.ingrediente VALUES (7, 'Magnesio');


--
-- Data for Name: laboratorio; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.laboratorio VALUES (1, 'God''s Nutrition', 'USA');
INSERT INTO public.laboratorio VALUES (2, 'Mason Natural', 'USA');
INSERT INTO public.laboratorio VALUES (3, 'Xtralife', 'Ecuador');
INSERT INTO public.laboratorio VALUES (4, 'Megalabs', 'Colombia');


--
-- Data for Name: suplemento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.suplemento VALUES (1, '1 scoop post-entreno', 'Whey Protein ISO', 85.5, 'Polvo 2lbs', 15, 1, 1, 4);
INSERT INTO public.suplemento VALUES (2, '2 capsulas diarias', 'Omega 3 Premium', 25, 'Frasco 100 caps', 30, 2, 2, 2);
INSERT INTO public.suplemento VALUES (3, '1 capsula diaria', 'L-Arginina 1000mg', 18.75, 'Frasco 60 caps', 5, 3, 4, 3);
INSERT INTO public.suplemento VALUES (4, '5g diarios', 'Creatina Monohidratada', 35, 'Polvo 300g', 50, 3, 5, 1);
INSERT INTO public.suplemento VALUES (5, '1 scoop antes de entrenar', 'Pre-Workout C4', 45, 'Polvo 30 servicios', 8, 4, 3, 1);
INSERT INTO public.suplemento VALUES (6, '1 scoop al despertar', 'Whey Protein Gold', 110, 'Polvo 5lbs', 10, 1, 6, 1);


--
-- Data for Name: suplemento_ingrediente; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.suplemento_ingrediente VALUES (1, 1);
INSERT INTO public.suplemento_ingrediente VALUES (1, 6);
INSERT INTO public.suplemento_ingrediente VALUES (1, 7);
INSERT INTO public.suplemento_ingrediente VALUES (2, 2);
INSERT INTO public.suplemento_ingrediente VALUES (3, 3);
INSERT INTO public.suplemento_ingrediente VALUES (4, 5);
INSERT INTO public.suplemento_ingrediente VALUES (5, 3);
INSERT INTO public.suplemento_ingrediente VALUES (5, 4);
INSERT INTO public.suplemento_ingrediente VALUES (6, 1);


--
-- Name: categoria_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categoria_id_seq', 4, true);


--
-- Name: detalle_nutricional_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.detalle_nutricional_id_seq', 6, true);


--
-- Name: ingrediente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ingrediente_id_seq', 7, true);


--
-- Name: laboratorio_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.laboratorio_id_seq', 4, true);


--
-- Name: suplemento_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.suplemento_id_seq', 6, true);


--
-- Name: categoria categoria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (id);


--
-- Name: detalle_nutricional detalle_nutricional_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalle_nutricional
    ADD CONSTRAINT detalle_nutricional_pkey PRIMARY KEY (id);


--
-- Name: ingrediente ingrediente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingrediente
    ADD CONSTRAINT ingrediente_pkey PRIMARY KEY (id);


--
-- Name: laboratorio laboratorio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.laboratorio
    ADD CONSTRAINT laboratorio_pkey PRIMARY KEY (id);


--
-- Name: suplemento suplemento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.suplemento
    ADD CONSTRAINT suplemento_pkey PRIMARY KEY (id);


--
-- Name: suplemento uk_apj9p3oady919id6wu558mir2; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.suplemento
    ADD CONSTRAINT uk_apj9p3oady919id6wu558mir2 UNIQUE (detalle_id);


--
-- Name: suplemento fk5tnaygd8fincpe3u66op9pxpu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.suplemento
    ADD CONSTRAINT fk5tnaygd8fincpe3u66op9pxpu FOREIGN KEY (detalle_id) REFERENCES public.detalle_nutricional(id);


--
-- Name: suplemento_ingrediente fkesnn7352d4pyxgbvtttsroyk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.suplemento_ingrediente
    ADD CONSTRAINT fkesnn7352d4pyxgbvtttsroyk1 FOREIGN KEY (ingrediente_id) REFERENCES public.ingrediente(id);


--
-- Name: suplemento fkf8ayr3ektjgghjprmu1fpb8e8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.suplemento
    ADD CONSTRAINT fkf8ayr3ektjgghjprmu1fpb8e8 FOREIGN KEY (laboratorio_id) REFERENCES public.laboratorio(id);


--
-- Name: suplemento_ingrediente fkfn6aqq5k0mr8417745uj2wvsb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.suplemento_ingrediente
    ADD CONSTRAINT fkfn6aqq5k0mr8417745uj2wvsb FOREIGN KEY (suplemento_id) REFERENCES public.suplemento(id);


--
-- Name: suplemento fkos08erifw4wiqhag5x5b7kw1f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.suplemento
    ADD CONSTRAINT fkos08erifw4wiqhag5x5b7kw1f FOREIGN KEY (categoria_id) REFERENCES public.categoria(id);


--
-- PostgreSQL database dump complete
--

\unrestrict uI3m6zhgL9DlnxvRe7kb0PEDXeWInhoW4Ps4ZQ7hSfpDaQLJvWufylWGFD9MAKp

