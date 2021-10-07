
public class EmployeeClass implements Cloneable{
	
	private String name;
	private Integer empid;
	private Integer depid;
	private Integer salary;
	private String status;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
	/*	result = prime * result + ((depid == null) ? 0 : depid.hashCode());
		result = prime * result + ((empid == null) ? 0 : empid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());*/
		return empid.hashCode();
	}
	public EmployeeClass(String name, Integer empid, Integer depid, Integer salary, String status) {
		super();
		this.name = name;
		this.empid = empid;
		this.depid = depid;
		this.salary = salary;
		this.status = status;
	}
	
	@Override  
	protected Object clone() throws CloneNotSupportedException {  
	// TODO Auto-generated method stub  
	return super.clone();  
	}  
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeClass other = (EmployeeClass) obj;
		if (depid == null) {
			if (other.depid != null)
				return false;
		} else if (!depid.equals(other.depid))
			return false;
		if (empid == null) {
			if (other.empid != null)
				return false;
		} else if (!empid.equals(other.empid))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EmployeeClass [name=" + name + ", empid=" + empid + ", depid=" + depid + ", salary=" + salary
				+ ", status=" + status + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public Integer getDepid() {
		return depid;
	}
	public void setDepid(Integer depid) {
		this.depid = depid;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
