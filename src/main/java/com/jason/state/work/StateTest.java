package com.jason.state.work;

/**
 * 状态模式: 将复杂的状态的逻辑判断 分解成 不同状态的一系列类当中, 可以把复杂的判断逻辑简化;
 *
 * 状态模式的好处是将与特定状态相关的行为局部化, 并且将不同状态的行为分割开来;
 */
public class StateTest {

    public static void main(String[] args) {

        // 紧急项目
        Work emergencyProjects = new Work();
        emergencyProjects.setHour(9.0);
        emergencyProjects.WriteProgram();
        emergencyProjects.setHour(10.0);
        emergencyProjects.WriteProgram();
        emergencyProjects.setHour(12.0);
        emergencyProjects.WriteProgram();
        emergencyProjects.setHour(13.0);
        emergencyProjects.WriteProgram();
        emergencyProjects.setHour(14.0);
        emergencyProjects.WriteProgram();
        emergencyProjects.setHour(17.0);

        emergencyProjects.setFinish(false);

        emergencyProjects.WriteProgram();
        emergencyProjects.setHour(19.0);
        emergencyProjects.WriteProgram();
        emergencyProjects.setHour(22.0);
        emergencyProjects.WriteProgram();
    }
}
