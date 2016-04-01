

/*
×÷Õß£ºÌ·Áø


*/

drop table if exists public;

drop table if exists reply;

drop table if exists user;

/*==============================================================*/
/* Table: public                                                */
/*==============================================================*/
create table public
(
   id                   varchar(64) not null,
   use_id               varchar(64) not null,
   title                varchar(80) not null,
   content              varchar(500) not null,
   time                 datetime not null,
   primary key (id)
);

/*==============================================================*/
/* Table: reply                                                 */
/*==============================================================*/
create table reply
(
   id                   varchar(64) not null,
   pub_id               varchar(64) not null,
   use_id               varchar(64) not null,
   content              text not null,
   time                 datetime not null,
   primary key (id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   varchar(64) not null,
   password             varchar(32) not null,
   username             varchar(32) not null,
   level                numeric(8,0) not null,
   email                varchar(32) not null,
   time                 datetime not null,
   primary key (id)
);

alter table public add constraint FK_userPublic foreign key (use_id)
      references user (id) on delete restrict on update restrict;

alter table reply add constraint FK_reply_blog foreign key (pub_id)
      references public (id) on delete restrict on update restrict;

alter table reply add constraint FK_user_reply foreign key (use_id)
      references user (id) on delete restrict on update restrict;
