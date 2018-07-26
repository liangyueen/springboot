package com.ly.xiyifu.rest.interfaces;


import com.ly.xiyifu.model.PageBean;
import com.ly.xiyifu.model.User;
import com.ly.xiyifu.rest.base.Response;
import com.ly.xiyifu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ly.xiyifu.constants.Constants.CURRENT_API_VERSION;


/**
 * 文件名称： UserRestAPI
 * <p>
 * 包路径： book.store.rest.interfaces
 * <p>
 * 版权所有：灵铱科技
 * <p>
 * 类描述：
 * <p>
 * 创建人： 程增辉
 * <p>
 * 创建时间： 2018/07/24 - 14:29
 * <p>
 * 修改记录：
 */
@Api(value = "用户信息", description = "用户信息")
@RestController
@RequestMapping(CURRENT_API_VERSION + "/app/users")
public class UserRestAPI extends BaseRestAPI {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "添加用户")
    @PostMapping("saveUser")
    public Response saveUser(User req) {
        return action(req, f -> {
            userService.saveUser(req);
            return null;
        });
    }


    @ApiOperation(value = "查询用户")
    @PostMapping("get")
    public Response getUser(String userId) {
        User result = userService.getByID(userId);

        return Response.ok.bindData(result);
    }

    @ApiOperation(value = "修改")
    @PostMapping("update")
    public Response update(User req) {
        return action(req, f -> userService.update(req));
    }


    @ApiOperation(value = "删除用户")
    @PostMapping("remove/{userId}")
    public Response removeUser(@PathVariable String userId) {

        userService.remove(userId);

        return Response.ok;
    }


    @ApiOperation(value = "用户列表")
    @GetMapping("list")
    public Response<List<User>> list(User req) {
        return action(req, f -> userService.list(req));
    }


    @ApiOperation(value = "分页")
    @GetMapping("page")
    public Response<PageBean<User>> listByPage(User req) {
        return action(req, f -> userService.page(req, req.getCurrentPage(), req.getPageSize()));
    }


}
