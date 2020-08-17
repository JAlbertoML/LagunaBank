package pojos;

import java.math.BigDecimal;
import java.util.Date;

public class Movement {
	public static final String MOV_TRANSFER = "Transferencia";
	public static final String MOV_WITHDRAWAL = "Retiro";
	public static final String MOV_PAYMENT = "Pago a cuenta";
	public static final String MOV_TOP_UP_BALANCE ="Recarga";

	private BigDecimal amount;
	private String type;
	private Date movDate;
	private String description;

	public Movement(BigDecimal amount, String type, Date movDate, String description) {
		super();
		this.amount = amount;
		this.type = type;
		this.movDate = movDate;
		this.description = description;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getMovDate() {
		return movDate;
	}

	public void setMovDate(Date movDate) {
		this.movDate = movDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
