-- 整个项目的数据库脚本
-- 开始创建一个数据库
-- CREATE DATABASE medicineRepertory;
-- 使用数据库
-- USE medicineRepertory;
-- 创建药品表
CREATE TABLE medicine(
  `medicine_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '药品库存id',
  `medicine_name` VARCHAR(120)  COMMENT '药品名称',
  `medicine_number` INT  COMMENT '库存数量',
  `production_date` TIMESTAMP  DEFAULT current_timestamp COMMENT '生产日期（单位；日）',
  `expiration_date` TIMESTAMP  COMMENT '保质期',
  `price` INT  COMMENT '售价',
  `medicine_permitment` VARCHAR (250) COMMENT '国药准字编码',
  `description` TEXT  COMMENT '详情描述：服用方法以及功效',
  `picture` VARCHAR(200) COMMENT '图片文件名',
  `warning_number` INT  DEFAULT 20 COMMENT '预警数量线',
  `medicine_supplier_id` BIGINT COMMENT '供应商',
  PRIMARY KEY (medicine_id),
  KEY (medicine_id)
)ENGINE =InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='药品表';

-- 创建工作人员表
CREATE TABLE worker(
  `worker_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '工作人员id编号',
  `worker_name` VARCHAR (120) NOT NULL COMMENT '工作人员姓名',
  `worker_password` VARCHAR(250)  DEFAULT 'password' COMMENT '员工密码',
  PRIMARY KEY (worker_id),
  KEY (worker_name)
)ENGINE =InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='简易工作人员表';

-- 创建进货表
CREATE TABLE replenish(
  `replenish_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '进货批次id',
  `replenish_medicine_id` BIGINT NOT NULL COMMENT '药品id',
  `create_time` TIMESTAMP  DEFAULT current_timestamp COMMENT '进货日期',
  `replenish_medicine_number` INT  COMMENT '进货数量',
  `replenish_medicine_price` INT COMMENT '进价',
  `replenish_worker_id` BIGINT NOT NULL COMMENT '经手员工ID',
  PRIMARY KEY (replenish_id),
  CONSTRAINT re_me_fk FOREIGN KEY (replenish_medicine_id) REFERENCES medicine(medicine_id) ON UPDATE CASCADE,
  CONSTRAINT re_wo_fk FOREIGN KEY (replenish_worker_id) REFERENCES worker(worker_id) ON UPDATE CASCADE
)ENGINE =InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='进货表';

-- 创建账目表
CREATE  TABLE bills(
  `bill_id` BIGINT  AUTO_INCREMENT COMMENT '账单id',
  `create_time` TIMESTAMP  DEFAULT current_timestamp COMMENT '生成时间',
  `bill_medicine_id` BIGINT  COMMENT '药品id',
  `bill_medicine_number` INT  COMMENT '药品数量',
  `bill_medicine_price` INT COMMENT '售价',
  `bill_worker_id`BIGINT COMMENT '经手员工ID',
  `bill_customer` VARCHAR(120) COMMENT '客户名称',
  PRIMARY KEY (bill_id),
  CONSTRAINT bi_me_fk FOREIGN KEY (bill_medicine_id) REFERENCES medicine(medicine_id) ON UPDATE CASCADE ,
  CONSTRAINT bi_wo_fk FOREIGN KEY (bill_worker_id) REFERENCES worker(worker_id)ON UPDATE CASCADE
)ENGINE =InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='账单表';

-- 创建供应商表
CREATE TABLE supplier(
  `supplier_id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '供应商ID',
  `spuulier_name` VARCHAR(120) COMMENT '供应商名字',
  `supplier_picture` VARCHAR(200) COMMENT '供应商图片名'
)ENGINE =InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='供应商表';