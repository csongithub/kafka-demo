/**
 * 
 */
package kafka.demo.common.message;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author chandan
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 371761310111687409L;
	
	public String message;
	
	
}
