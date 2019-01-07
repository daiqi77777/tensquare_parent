package entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageResult<T> {

	private Long total;

	private List<T> rows;

	public PageResult(Long total, List<T> rows) {
		this.total = total;
		this.rows = rows;
	}
}
