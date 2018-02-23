package com.jason.composite;

/**
 * 组合模式
 *
 * a) 定义组合元
 *
 * b) 每个组合元中包含多个子组合
 *
 * c) 根组合实例化
 *
 * d) 子组合实例化, 子组合的列表默认留空
 *
 * e) 将子组合添加到根组合的列表中
 */
public class CompositeTest {

    public static void main(String[] args) {
        ConcreteCompany root = new ConcreteCompany("总公司");
        root.Add(new HRDepartment("总公司人力资源部"));
        root.Add(new FinanceDepartment("总公司财务部"));

        ConcreteCompany company = new ConcreteCompany("分公司");
        company.Add(new HRDepartment("分公司人力资源部"));
        company.Add(new FinanceDepartment("分公司财务部"));
        root.Add(company);

        System.out.println("结构图：");
        root.Display(1);
    }
}
