package transaction;

/**
 * 一事务的提交方式：
 *      1.自动提交事务:
 *          mysql中在增删改时默认自动提交事务：select @@autocommit
 *      2.手动提交事务：
 *          start transaction 开启事务
 *          rollback 执行出现异常，回滚事务
 *          commit 执行成功，提供事务
 *   二：事务的四大特性：
 *      1.原子性：多个事务执行，要么同时执行成功，要么同时不执行（同时执行失败）
 *      2.持久性：在事务提交之后，对数据库中的数据进行修改，应该永久保存
 *      3.一致性：事务操作前后，应保存数据的完整性
 *      4.隔离性：多个事务执行，相互不影响
 *   三：事务常见的并发问题：
 *      1.脏读：读取到另一个没有提交事务的数据
 *      2.幻读：事务A和B，事务A查询表中所有数据，事务B新增一条数据，导致A再次查询就多莫名出了几行；
 *      3.不可重复读：在同一个事务中，多次读取到数据都不一样
 *   四：事务的隔离级别（四大）：
 *      1.read uncommitted 读未提交
 *          *可能出现的问题；脏读，幻读，不可重复读，
 *      2.read committed 读已提交。可解决脏读（oracle默认的隔离级别）
 *          *可能出现的问题：幻读，不可重复读的问题
 *      3.repeatable read 可重复读，可解决不可重复读的问题（mysql默认的隔离级别）
 *          *可能出现的问题：脏读，幻读
 *      4.serializable 串行化,类似锁表操作，锁住当前事务的表，不允许其他事务操作当前表
 *          *可解决出现的脏读，幻读，不可重复代等问题，但是效率越来越低、
 *
 *
 *   五：SQL分类：
 *      1.DDL(Data Definition Language): 定义操作数据和表
 *      2.DML(Data Manipulation Language):增删改表中的数据
 *      3.DQL(Data Query Language):查询表中的数据
 *      4.DCL(Data Control Language):管理用户授权
 *          *DBA(DataBase Administration)数据库管理员
 *
 * */
public class DemoMain {
}