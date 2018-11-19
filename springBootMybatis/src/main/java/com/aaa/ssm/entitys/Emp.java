package com.aaa.ssm.entitys;

public class Emp {
    /**
     * className:Emp
     * discriptoin:
     * author:邢博
     * createTime:2018-11-09 15:52
     */

        private Integer empNo;
        private String ename;
        private String job;
        private double salary;
        private String marName;
        private String hireDate;
        private double comm;
        private String deptName;
        private Integer deptNo;

        public Integer getDeptNo() {
            return deptNo;
        }

        public void setDeptNo(Integer deptNo) {
            this.deptNo = deptNo;
        }

        public Integer getEmpNo() {
            return empNo;
        }

        public void setEmpNo(Integer empNo) {
            this.empNo = empNo;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getMarName() {
            return marName;
        }

        public void setMarName(String marName) {
            this.marName = marName;
        }

        public String getHireDate() {
            return hireDate;
        }

        public void setHireDate(String hireDate) {
            this.hireDate = hireDate;
        }

        public double getComm() {
            return comm;
        }

        public void setComm(double comm) {
            this.comm = comm;
        }

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

    }

