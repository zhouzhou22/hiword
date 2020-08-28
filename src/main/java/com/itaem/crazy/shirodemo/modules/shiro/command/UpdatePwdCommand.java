package com.itaem.crazy.shirodemo.modules.shiro.command;

import com.itaem.crazy.shirodemo.common.validation.GroupCommand;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

/**
 * @ProjectName ：com.itaem.crazy.shirodemo.modules.shiro.command
 * @Description:
 * @MClassName: UpdatePwdCommand
 * @Authur: yangjianyi
 * @Date: 2020/4/18 21:58
 */
@Data
@ToString
public class UpdatePwdCommand extends BaseCommand implements Serializable {


    /**
     *old密码
     */
    @NotNull(message = "原始密码不能为空")
    @NotBlank(message = "原始密码不能为空")
    private String password;
    /**
     * 新密码
     */
    @NotNull(message = "新密码不能为空")
    @NotBlank(message = "新密码不能为空")
    private String newPwd;
    /**
     * 确认密码
     */
    @NotNull(message = "确认密码不能为空")
    @NotBlank(message = "确认密码不能为空")
    private String newPassword1;

}
