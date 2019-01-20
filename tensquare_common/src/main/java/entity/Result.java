package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {

	private boolean flag;// 是否成功

	private Integer code;// 返回码

	private String message;// 返回信息

	private Object data;// 返回数据

	public Result() {

	}
	
	public Result(boolean flag, Integer code, String message, Object data) {
		this.flag = flag;
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	/**
	 * 只返回成功,不带数据的
	 * @return ResponseWrapper
	 */
	public static Result success() {
		return new Result(true,StatusCode.OK,"OK",null);
	}
	
	/**
	 * 返回成功，带数据的
	 * @return ResponseWrapper
	 */
	public static Result success(Object data) {
		return new Result(true,StatusCode.OK,"OK",data);
	}
	
	/**
	 * 返回失败
	 * @return ResponseWrapper
	 */
	public static Result error() {
		return new Result(false,StatusCode.ERROR,"抱歉,服务器异常",null);
	}

	/**
	 * 返回失败
	 *
	 * @return ResponseWrapper
	 */
	public static Result error(int code,String message) {
		return new Result(false, code, message, null);
	}
}