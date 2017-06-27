-- db_mybatis_pp.sql                                                                                                  
/*
Navicat PGSQL Data Transfer

Source Server         : KSHRD_DB
Source Server Version : 90401
Source Host           : localhost:5432
Source Database       : db_mybatis_pp
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90401
File Encoding         : 65001

Date: 2017-06-27 01:55:00
*/


-- ----------------------------
-- Sequence structure for users_id_seq
-- ----------------------------
-- DROP SEQUENCE "public"."users_id_seq";
-- CREATE SEQUENCE "public"."users_id_seq"
--  INCREMENT 1
--  MINVALUE 1
--  MAXVALUE 9223372036854775807
--  START 37
--  CACHE 1;
-- SELECT setval('"public"."users_id_seq"', 37, true);

-- ----------------------------
-- Table structure for users
-- ----------------------------
-- DROP TABLE IF EXISTS "public"."users";
CREATE TABLE "public"."users" (
"id" serial PRIMARY KEY,
"username" varchar(100),
"email" varchar(100),
"gender" varchar(1),
"phonenumber" varchar(100),
"status" varchar(1),
"user_hash" varchar(100),
"created_date" timestamp(6)
);

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO "public"."users" VALUES ('1', 'Kun SeakLeng', 'kunseakleng@gmail.com', 'm', '09691999292', null, '5ad5d2d2-6884-4112-9d22-1c6ff17d8b6a', '2017-06-23 22:39:53.257');
INSERT INTO "public"."users" VALUES ('2', 'Kun SeakLeng', 'kunseakleng@gmail.com', 'm', '09691999292', null, '65bf4d5d-9884-42b4-8df1-8cbe9439b702', '2017-06-23 22:41:47.107');
INSERT INTO "public"."users" VALUES ('3', 'Kun SeakLeng', 'kunseakleng@gmail.com', 'm', '09691999292', 'y', '6202218d-edab-488d-bc64-e23e9323757c', '2017-06-23 22:43:52.144');
INSERT INTO "public"."users" VALUES ('4', 'Kun SeakLeng', 'kunseakleng@gmail.com', 'm', '09691999292', null, '3bef06d7-844e-403a-bec0-2e741f2e5aa1', '2017-06-23 22:49:54.136');
INSERT INTO "public"."users" VALUES ('5', 'Kun SeakLeng8', 'kunseakleng@gmail.com8', 'm', '096919992928', '', '535c2c1a-6f42-4cf5-bd7a-6c3cd739f278', '2017-06-23 22:54:08.092');
INSERT INTO "public"."users" VALUES ('6', 'Kun SeakLen', 'kunseakleng@gmail.com', 'f', '0969199', 'y', 'be7f8f12-0cb0-4327-913c-a827d4358f50', '2017-06-23 22:56:21.626');
INSERT INTO "public"."users" VALUES ('7', 'Kun SeakLeng10', 'kuntola883@yahoo.com10', 'm', '0969199929210', 'y', '94763248-2597-4b43-b978-cc57c8a2196c', '2017-06-23 22:57:35.229');
INSERT INTO "public"."users" VALUES ('8', 'Kun Seak3333', 'kuntola883@yahoo.com', 'm', '09691999292', null, '07d9a526-2ddc-4f7b-bbfc-76bd8fb0e534', '2017-06-23 23:01:34.645');
INSERT INTO "public"."users" VALUES ('9', 'Kun SeakLeng12', 'kuntola883@yahoo.com', 'm', '09691999292', '', 'ba1727f8-0844-48be-872a-842b8cf3865b', '2017-06-23 23:09:49.918');
INSERT INTO "public"."users" VALUES ('10', 'Kun SeakLeng122', 'kuntola883@yahoo.com', 'm', '09691999292', '', '0d9096b0-38c2-4bf3-86b0-2645d3f92ce0', '2017-06-25 11:37:06.593');
INSERT INTO "public"."users" VALUES ('11', 'Kun SeakLeng12', 'kuntola883@yahoo.com', 'm', '09691999292', 'y', 'facff86c-b256-4946-8f5e-f9280bf988e9', '2017-06-26 11:53:41.652');
INSERT INTO "public"."users" VALUES ('12', 'Kun SeakLeng44', 'kuntola883@yahoo.com', 'm', '09691999292', 'y', '0c1b6331-a2e9-420a-8c10-f87f4340b78f', '2017-06-26 14:31:00.202');
INSERT INTO "public"."users" VALUES ('13', 'Kun SeakLeng', 'kuntola883@yahoo.com', 'm', '09691999292', null, '653fa44b-4df3-4110-b9c2-398f1e274404', '2017-06-26 14:57:04.014');
INSERT INTO "public"."users" VALUES ('14', 'ly huot', 'kuntola883@yahoo.com', 'm', '09691999292', null, '7371a5bb-4920-47cb-9a7c-9b77489ed29d', '2017-06-26 17:16:53.239');
INSERT INTO "public"."users" VALUES ('15', 'jlsdf', 'kuntola883@yahoo.com', 'm', '09691999292', '', '019116e7-48c5-48be-a964-a1ff1afc18b7', '2017-06-26 17:17:17.511');
INSERT INTO "public"."users" VALUES ('16', 'Kun SeakLeng000', 'kuntola883@yahoo.com', 'm', '09691999292', null, 'b429d41c-a393-4676-ba4a-7235b38a9c77', '2017-06-26 23:03:03.473');
INSERT INTO "public"."users" VALUES ('17', 'Kun', 'kuntola883@yahoo.com', 'm', '09691999292', 'y', '7dd46e20-621c-468e-842b-901605366aa2', '2017-06-26 23:03:29.931');
INSERT INTO "public"."users" VALUES ('18', 'SeakLeng', 'kuntola883@yahoo.com', 'm', '09691999292', null, '1108c355-c040-4171-8014-976a279c162a', '2017-06-26 23:04:42.591');
INSERT INTO "public"."users" VALUES ('19', 'Chan', 'kuntola883@yahoo.com', 'f', '09691999292', null, '258c43b2-226b-4119-a434-efa30d5b0d14', '2017-06-27 01:28:38.186');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------
-- ALTER SEQUENCE "public"."users_id_seq" OWNED BY "users"."id";
-- 
-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
-- ALTER TABLE "public"."users" ADD PRIMARY KEY ("id");
-- 