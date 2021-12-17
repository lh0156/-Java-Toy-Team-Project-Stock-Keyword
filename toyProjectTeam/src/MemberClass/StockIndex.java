package MemberClass;

public class StockIndex {
	private String name = ""; // 회사이름
	private String eps;
	private String bps;
	private String per;
	private String businessPer;// 업종PER
	private String pbr;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public String getBps() {
		return bps;
	}

	public void setBps(String bps) {
		this.bps = bps;
	}

	public String getPer() {
		return per;
	}

	public void setPer(String per) {
		this.per = per;
	}

	public String getBusinessPer() {
		return businessPer;
	}

	public void setBusinessPer(String businessPer) {
		this.businessPer = businessPer;
	}

	public String getPbr() {
		return pbr;
	}

	public void setPbr(String pbr) {
		this.pbr = pbr;
	}

	@Override
	public String toString() {
		return "StockIndex [name=" + name + ", eps=" + eps + ", bps=" + bps + ", per=" + per + ", businessPer="
				+ businessPer + ", pbr=" + pbr + "]";
	}
}