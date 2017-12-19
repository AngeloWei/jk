CREATE  DATABASE stu;
USE  stu;

-- 创建jk的相关表
-- 工厂信息表
drop table IF EXISTS factory_info;
CREATE TABLE `factory_info` (
  `Factory_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `Full_Name` varchar(200) DEFAULT NULL COMMENT '全称',
  `Factory_Name` varchar(30) DEFAULT NULL COMMENT '简称',
  `Contacts` varchar(30) DEFAULT NULL COMMENT '联系人',
  `Phone` varchar(30) DEFAULT NULL COMMENT '电话',
  `Mobile` varchar(30) DEFAULT NULL COMMENT '手机',
  `Fax` varchar(30) DEFAULT NULL COMMENT '传真',
  `Cnote` varchar(2000) DEFAULT NULL COMMENT '备注',
  `Inspector` varchar(30) DEFAULT NULL COMMENT '验货员',
  `Order_No` varchar(30) DEFAULT NULL COMMENT '排序号',
  `Create_Name` varchar(30) DEFAULT NULL COMMENT '创建人',
  `Create_Dept` varchar(30) DEFAULT NULL COMMENT '创建部门',
  `Create_Time` date DEFAULT NULL COMMENT '创建时间',
  `state` int(11) NOT NULL COMMENT '状态',
  PRIMARY KEY (`Factory_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1007 DEFAULT CHARSET=utf8 ;

drop table if exists CONTRACT_C;

drop table if exists EXT_CPRODUCT_C;

drop table if exists SYS_CODE_B;

/*==============================================================*/
/* Table: CONTRACT_C                                            */
/*==============================================================*/
create table CONTRACT_C
(
  CONTRACT_ID          varchar(40) not null,
  OFFEROR              varchar(200),
  CONTRACT_NO          varchar(50),
  SIGNING_DATE         datetime,
  INPUT_BY             varchar(30),
  CHECK_BY             varchar(30),
  INSPECTOR            varchar(30),
  TOTAL_AMOUNT         numeric(10,2),
  CREQUEST             varchar(2000),
  CUSTOM_NAME          varchar(200),
  SHIP_TIME            datetime,
  IMPORT_NUM           int comment '打印时标识几个星,对应说明中的内容',
  DELIVERY_PERIOD      datetime,
  REMARK               varchar(600),
  PRINT_STYLE          char(1) comment '宽2:一页两个货物  窄1:一页一个货物',
  OLD_STATE            int comment '归档前状态, 方便回退',
  STATE                int comment '0草稿 1已上报待报运

            归档后, 其他选择合同的地方均去除.
            表示合同已完成, 不论是否合同的货物是否全部真的走完, 因为有赔付等其他情况',
  OUT_STATE            int comment '0未走货 1部分 2全部

            归档后, 其他选择合同的地方均去除.
            表示合同已完成, 不论是否合同的货物是否全部真的走完, 因为有赔付等其他情况',
  TRADE_TERMS          varchar(30),
  CREATE_BY            varchar(40),
  CREATE_DEPT          varchar(40),
  CREATE_TIME          datetime,
  primary key (CONTRACT_ID)
);

alter table CONTRACT_C comment '界面参考用户提供的《供销合同》';

/*==============================================================*/
/* Table: EXT_CPRODUCT_C                                        */
/*==============================================================*/
create table EXT_CPRODUCT_C
(
  EXT_CPRODUCT_ID      varchar(40) not null,
  FACTORY_ID           varchar(40),
  CONTRACT_PRODUCT_ID  varchar(40),
  CTYPE                int comment 'SYS_CODE=0104',
  PRODUCT_NAME         varchar(200),
  PRODUCT_NO           varchar(50),
  PRODUCT_IMAGE        varchar(200),
  PRODUCT_DESC         varchar(600),
  LOADING_RATE         varchar(30) comment 'x/y',
  PACKING_UNIT         varchar(10) comment 'PCS/SETS',
  CNUMBER              int,
  OUT_NUMBER           int,
  FINISHED             bit,
  GROSS_WEIGHT         numeric(10,2),
  NET_WEIGHT           numeric(10,2),
  SIZE_LENGTH          numeric(10,2),
  SIZE_WIDTH           numeric(10,2),
  SIZE_HEIGHT          numeric(10,2),
  PRODUCT_REQUEST      varchar(2000),
  FACTORY_NAME         varchar(200),
  PRICE                numeric(10,2),
  AMOUNT               numeric(10,2) comment '自动计算: 数量x单价',
  CUNIT                varchar(10),
  BOX_NUM              int,
  EX_PRICE             numeric(10,2),
  EX_UNIT              varchar(10) comment '$/￥',
  NO_TAX               numeric(10,2) comment '收购单价',
  TAX                  numeric(10,2) comment '收购单价',
  COST_PRICE           numeric(10,2) comment '自动计算=数量x含税/1.17标准值',
  COST_TAX             numeric(10,2) comment '自动计算=数量x含税-收购成本金额',
  ACCESSORIES          bit,
  ORDER_NO             int,
  primary key (EXT_CPRODUCT_ID)
);

alter table EXT_CPRODUCT_C comment '一款货可对应多个附件，目前只有彩盒、花纸、保丽龙';

/*==============================================================*/
/* Table: SYS_CODE_B                                            */
/*==============================================================*/
create table SYS_CODE_B
(
  SYS_CODE_ID          varchar(40) not null,
  NAME                 varchar(100),
  PARENT_ID            varchar(40),
  PARENT_NAME          varchar(100),
  LAYER_NUM            int,
  IS_LEAF              int,
  QUOTE_NUM            int,
  CNOTE                varchar(100),
  ICO                  varchar(20),
  ORDER_NO             int,
  STATE                char(1),
  CREATED_BY           varchar(40),
  CREATED_TIME         datetime,
  UPDATED_BY           varchar(40),
  UPDATED_TIME         datetime,
  primary key (SYS_CODE_ID)
);

alter table SYS_CODE_B comment '数据字典';

-- 合同货物表
create table CONTRACT_PRODUCT_C
(
  CONTRACT_PRODUCT_ID  varchar(40) not null,
  CONTRACT_ID          varchar(40),
  FACTORY_ID           varchar(40),
  FACTORY_NAME         varchar(200) comment '冗余',
  EXPORT_LIST_ID       varchar(40),
  INVOICE_ID           varchar(40),
  PRODUCT_NAME         varchar(200),
  PRODUCT_NO           varchar(50),
  PRODUCT_IMAGE        varchar(200),
  PRODUCT_DESC         varchar(600),
  LOADING_RATE         varchar(30) comment 'x/y',
  PACKING_UNIT         varchar(10) comment 'PCS/SETS',
  CNUMBER              int,
  OUT_NUMBER           int,
  FINISHED             bit,
  GROSS_WEIGHT         numeric(10,2),
  NET_WEIGHT           numeric(10,2),
  CSIZE                varchar(20),
  SIZE_LENGTH          numeric(10,2),
  SIZE_WIDTH           numeric(10,2),
  SIZE_HEIGHT          numeric(10,2),
  PRODUCT_REQUEST      varchar(2000),
  PRICE                numeric(10,2),
  AMOUNT               numeric(10,2) comment '自动计算: 数量x单价',
  CUNIT                varchar(10),
  BOX_NUM              int,
  EX_PRICE             numeric(10,2),
  EX_AMOUNT            numeric(10,2),
  EX_UNIT              varchar(10) comment '$/￥',
  NO_TAX               numeric(10,2) comment '收购单价',
  TAX                  numeric(10,2) comment '收购单价',
  COST_PRICE           numeric(10,2) comment '自动计算=数量x含税/1.17标准值',
  COST_TAX             numeric(10,2) comment '自动计算=数量x含税-收购成本金额',
  ACCESSORIES          bit,
  ORDER_NO             int,
  primary key (CONTRACT_PRODUCT_ID)
);

