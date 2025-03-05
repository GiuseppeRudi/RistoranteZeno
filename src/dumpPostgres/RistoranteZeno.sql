--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.2

-- Started on 2025-01-17 21:35:16

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 5 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: RistoranteZeno
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO "RistoranteZeno";

--
-- TOC entry 4947 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: RistoranteZeno
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 224 (class 1259 OID 16433)
-- Name: cucina; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cucina (
    id integer NOT NULL,
    cucina character varying(100) NOT NULL,
    password character varying(255) NOT NULL
);


ALTER TABLE public.cucina OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16439)
-- Name: cucina_cinese; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cucina_cinese (
    id integer NOT NULL,
    nome character varying(255),
    ingredienti text,
    immagine character varying(255),
    prezzo numeric
);


ALTER TABLE public.cucina_cinese OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 16446)
-- Name: cucina_giapponese; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cucina_giapponese (
    id integer NOT NULL,
    nome character varying(255),
    ingredienti text,
    immagine character varying(255),
    prezzo numeric
);


ALTER TABLE public.cucina_giapponese OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16403)
-- Name: cucina_italiana; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cucina_italiana (
    id integer NOT NULL,
    nome character varying(255),
    ingredienti text,
    immagine character varying(255),
    prezzo numeric
);


ALTER TABLE public.cucina_italiana OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16432)
-- Name: cucina_login_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cucina_login_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.cucina_login_id_seq OWNER TO postgres;

--
-- TOC entry 4952 (class 0 OID 0)
-- Dependencies: 223
-- Name: cucina_login_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cucina_login_id_seq OWNED BY public.cucina.id;


--
-- TOC entry 222 (class 1259 OID 16421)
-- Name: ordine_piatto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ordine_piatto (
    ordine_id integer,
    piatto_nome character varying(255),
    prezzo numeric(10,2)
);


ALTER TABLE public.ordine_piatto OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16414)
-- Name: ordini; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ordini (
    id integer NOT NULL,
    num_tavolo integer,
    data timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    totale numeric(10,2)
);


ALTER TABLE public.ordini OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16413)
-- Name: ordini_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ordini_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.ordini_id_seq OWNER TO postgres;

--
-- TOC entry 4955 (class 0 OID 0)
-- Dependencies: 220
-- Name: ordini_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ordini_id_seq OWNED BY public.ordini.id;


--
-- TOC entry 218 (class 1259 OID 16397)
-- Name: tavoli; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tavoli (
    id integer NOT NULL,
    numero_tavolo character varying(50) NOT NULL,
    password character varying(255) NOT NULL
);


ALTER TABLE public.tavoli OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16396)
-- Name: tavoli_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tavoli_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tavoli_id_seq OWNER TO postgres;

--
-- TOC entry 4957 (class 0 OID 0)
-- Dependencies: 217
-- Name: tavoli_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tavoli_id_seq OWNED BY public.tavoli.id;


--
-- TOC entry 4773 (class 2604 OID 16436)
-- Name: cucina id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cucina ALTER COLUMN id SET DEFAULT nextval('public.cucina_login_id_seq'::regclass);


--
-- TOC entry 4771 (class 2604 OID 16417)
-- Name: ordini id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordini ALTER COLUMN id SET DEFAULT nextval('public.ordini_id_seq'::regclass);


--
-- TOC entry 4770 (class 2604 OID 16400)
-- Name: tavoli id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tavoli ALTER COLUMN id SET DEFAULT nextval('public.tavoli_id_seq'::regclass);


--
-- TOC entry 4939 (class 0 OID 16433)
-- Dependencies: 224
-- Data for Name: cucina; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cucina (id, cucina, password) FROM stdin;
2	cinese	cinese2025
1	italiana	italiana2025
3	giapponese	giapponese2025
\.


--
-- TOC entry 4940 (class 0 OID 16439)
-- Dependencies: 225
-- Data for Name: cucina_cinese; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cucina_cinese (id, nome, ingredienti, immagine, prezzo) FROM stdin;
1	Jiaozi (Dumplings)	Farina, carne di maiale, gamberi, cavolo cinese, zenzero, aglio, salsa di soia	jiaozi.jpg	15.00
2	Riso Fritto alla Cantonese	Riso, uova, piselli, prosciutto, cipolla verde, salsa di soia	riso_fritto_cantonese.jpg	12.00
3	Zuppa Agrodolce	Brodo di pollo, ananas, peperoni, cipolla, salsa agrodolce, aceto di riso	zuppa_agrodolce.jpg	10.00
4	Pollo Kung Pao	Pollo, arachidi, peperoncini secchi, salsa di soia, aceto di riso, zucchero	pollo_kung_pao.jpg	18.00
5	Anatra alla Pechinese	Anatra, salsa hoisin, pancake cinese, cipollotto, cetriolo	anatra_pechinese.jpg	25.00
6	Manzo con Broccoli	Manzo, broccoli, salsa di soia, aglio, zenzero, zucchero	manzo_broccoli.jpg	20.00
7	Tang Yuan (Dolci di Riso Glutinoso)	Farina di riso glutinoso, pasta di sesamo nero, sciroppo di zucchero	tang_yuan.jpg	8.00
8	Moon Cake	Farina, zucchero, pasta di fagioli rossi, frutta secca, semi di loto	moon_cake.jpg	10.00
\.


--
-- TOC entry 4941 (class 0 OID 16446)
-- Dependencies: 226
-- Data for Name: cucina_giapponese; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cucina_giapponese (id, nome, ingredienti, immagine, prezzo) FROM stdin;
1	Sushi Misto	Riso per sushi, pesce fresco (tonno, salmone, anguilla), alghe nori, wasabi, salsa di soia	sushi_misto.jpg	25.00
2	Ramen Tonkotsu	Brodo di maiale, noodles, uova sode, porro, alga nori, salsa di soia	ramen_tonkotsu.jpg	20.00
3	Udon con Tempura	Udon (spaghetti di grano), tempura di gamberi, brodo di dashi, cipollotto, alga nori	udon_tempura.jpg	18.00
4	Tempura di Gamberi	Gamberi, pastella di farina e acqua, olio per friggere, salsa tentsuyu	tempura_gamberi.jpg	22.00
5	Kaiseki	Pesce crudo, carne, verdure stagionali, riso, brodo, tofu, piatti preparati con tecniche raffinate	kaiseki.jpg	50.00
6	Unagi Don	Anguilla grigliata, riso, salsa tare	unagi_don.jpg	30.00
7	Mochi al Tè Verde	Riso glutinoso, pasta di fagioli rossi, polvere di tè verde matcha	mochi_tea.jpg	8.00
8	Dorayaki	Due pancake ripieni di anko (pasta di fagioli rossi)	dorayaki.jpg	6.00
\.


--
-- TOC entry 4934 (class 0 OID 16403)
-- Dependencies: 219
-- Data for Name: cucina_italiana; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cucina_italiana (id, nome, ingredienti, immagine, prezzo) FROM stdin;
1	Risotto alla Milanese	Riso, brodo di carne, zafferano, burro, parmigiano	risotto_milanese.jpg	25.00
2	Tagliatelle al Tartufo Bianco	Tagliatelle, burro, panna, parmigiano, tartufo bianco	tagliatelle_tartufo.jpg	30.00
3	Lasagna alla Bolognese	Pasta all’uovo, carne macinata, besciamella, pomodoro, parmigiano	lasagna_bolognese.jpg	28.00
4	Filetto di Manzo alla Fiorentina	Filetto di manzo, olio d’oliva, rosmarino, aglio	filetto_fiorentina.jpg	40.00
5	Branzino al Sale	Branzino, sale grosso, olio d’oliva, limone	branzino_sale.jpg	35.00
6	Ossobuco alla Milanese	Stinco di vitello, cipolla, pomodoro, vino bianco, brodo	ossobuco_milanese.jpg	38.00
7	Tiramisù	Mascarpone, uova, caffè, savoiardi, cacao	tiramisu.jpg	15.00
8	Zabaglione con Frutta Fresca	Marsala, uova, zucchero, frutta di stagione	zabaglione_frutta.jpg	18.00
\.


--
-- TOC entry 4937 (class 0 OID 16421)
-- Dependencies: 222
-- Data for Name: ordine_piatto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ordine_piatto (ordine_id, piatto_nome, prezzo) FROM stdin;
\.


--
-- TOC entry 4936 (class 0 OID 16414)
-- Dependencies: 221
-- Data for Name: ordini; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ordini (id, num_tavolo, data, totale) FROM stdin;
\.


--
-- TOC entry 4933 (class 0 OID 16397)
-- Dependencies: 218
-- Data for Name: tavoli; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tavoli (id, numero_tavolo, password) FROM stdin;
1	1	zeno1
2	2	zeno2
3	3	zeno3
4	4	zeno4
5	5	zeno5
6	6	zeno6
7	7	zeno7
8	8	zeno8
9	9	zeno9
10	10	zeno10
\.


--
-- TOC entry 4958 (class 0 OID 0)
-- Dependencies: 223
-- Name: cucina_login_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cucina_login_id_seq', 3, true);


--
-- TOC entry 4959 (class 0 OID 0)
-- Dependencies: 220
-- Name: ordini_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ordini_id_seq', 21, true);


--
-- TOC entry 4960 (class 0 OID 0)
-- Dependencies: 217
-- Name: tavoli_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tavoli_id_seq', 10, true);


--
-- TOC entry 4783 (class 2606 OID 16445)
-- Name: cucina_cinese cucina_cinese_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cucina_cinese
    ADD CONSTRAINT cucina_cinese_pkey PRIMARY KEY (id);


--
-- TOC entry 4785 (class 2606 OID 16452)
-- Name: cucina_giapponese cucina_giapponese_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cucina_giapponese
    ADD CONSTRAINT cucina_giapponese_pkey PRIMARY KEY (id);


--
-- TOC entry 4777 (class 2606 OID 16409)
-- Name: cucina_italiana cucina_italiana_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cucina_italiana
    ADD CONSTRAINT cucina_italiana_pkey PRIMARY KEY (id);


--
-- TOC entry 4781 (class 2606 OID 16438)
-- Name: cucina cucina_login_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cucina
    ADD CONSTRAINT cucina_login_pkey PRIMARY KEY (id);


--
-- TOC entry 4779 (class 2606 OID 16420)
-- Name: ordini ordini_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordini
    ADD CONSTRAINT ordini_pkey PRIMARY KEY (id);


--
-- TOC entry 4775 (class 2606 OID 16402)
-- Name: tavoli tavoli_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tavoli
    ADD CONSTRAINT tavoli_pkey PRIMARY KEY (id);


--
-- TOC entry 4786 (class 2606 OID 16424)
-- Name: ordine_piatto ordine_piatto_ordine_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordine_piatto
    ADD CONSTRAINT ordine_piatto_ordine_id_fkey FOREIGN KEY (ordine_id) REFERENCES public.ordini(id);


--
-- TOC entry 4948 (class 0 OID 0)
-- Dependencies: 224
-- Name: TABLE cucina; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE public.cucina FROM postgres;
GRANT ALL ON TABLE public.cucina TO PUBLIC;
GRANT ALL ON TABLE public.cucina TO "adminRistoranteZeno";
GRANT ALL ON TABLE public.cucina TO "RistoranteZeno";


--
-- TOC entry 4949 (class 0 OID 0)
-- Dependencies: 225
-- Name: TABLE cucina_cinese; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE public.cucina_cinese FROM postgres;
GRANT ALL ON TABLE public.cucina_cinese TO PUBLIC;
GRANT ALL ON TABLE public.cucina_cinese TO "adminRistoranteZeno";
GRANT ALL ON TABLE public.cucina_cinese TO "RistoranteZeno";


--
-- TOC entry 4950 (class 0 OID 0)
-- Dependencies: 226
-- Name: TABLE cucina_giapponese; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE public.cucina_giapponese FROM postgres;
GRANT ALL ON TABLE public.cucina_giapponese TO PUBLIC;
GRANT ALL ON TABLE public.cucina_giapponese TO "adminRistoranteZeno";
GRANT ALL ON TABLE public.cucina_giapponese TO "RistoranteZeno";


--
-- TOC entry 4951 (class 0 OID 0)
-- Dependencies: 219
-- Name: TABLE cucina_italiana; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE public.cucina_italiana FROM postgres;
GRANT ALL ON TABLE public.cucina_italiana TO PUBLIC;
GRANT ALL ON TABLE public.cucina_italiana TO "adminRistoranteZeno";
GRANT ALL ON TABLE public.cucina_italiana TO "RistoranteZeno";


--
-- TOC entry 4953 (class 0 OID 0)
-- Dependencies: 222
-- Name: TABLE ordine_piatto; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE public.ordine_piatto FROM postgres;
GRANT ALL ON TABLE public.ordine_piatto TO PUBLIC;
GRANT ALL ON TABLE public.ordine_piatto TO "adminRistoranteZeno";
GRANT ALL ON TABLE public.ordine_piatto TO "RistoranteZeno";


--
-- TOC entry 4954 (class 0 OID 0)
-- Dependencies: 221
-- Name: TABLE ordini; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE public.ordini FROM postgres;
GRANT ALL ON TABLE public.ordini TO PUBLIC;
GRANT ALL ON TABLE public.ordini TO "adminRistoranteZeno";
GRANT ALL ON TABLE public.ordini TO "RistoranteZeno";


--
-- TOC entry 4956 (class 0 OID 0)
-- Dependencies: 218
-- Name: TABLE tavoli; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE public.tavoli FROM postgres;
GRANT ALL ON TABLE public.tavoli TO PUBLIC;
GRANT ALL ON TABLE public.tavoli TO "RistoranteZeno";


--
-- TOC entry 2071 (class 826 OID 16395)
-- Name: DEFAULT PRIVILEGES FOR TABLES; Type: DEFAULT ACL; Schema: public; Owner: postgres
--

ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA public GRANT ALL ON TABLES TO PUBLIC;
ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA public GRANT ALL ON TABLES TO "adminRistoranteZeno";
ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA public GRANT ALL ON TABLES TO "RistoranteZeno";


-- Completed on 2025-01-17 21:35:16

--
-- PostgreSQL database dump complete
--

