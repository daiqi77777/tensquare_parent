package com.tensquare.spit.controller;

import com.tensquare.spit.pojp.Spit;
import com.tensquare.spit.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author 冯彧
 * @date 2019/1/20 20:44
 * @description
 */
@RestController
@CrossOrigin
@RequestMapping("spit")
public class SpitController {


    @Autowired
    private SpitService spitService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    public Result findAll() {
        return Result.success(spitService.findAll());
    }

    @GetMapping("{spitId}")
    public Result findById(@PathVariable String spitId) {
        return Result.success(spitService.findById(spitId));
    }

    @PostMapping
    public Result save(@RequestBody Spit spit) {
        spitService.save(spit);
        return Result.success();
    }

    @PutMapping("{spitId}")
    public Result update(@RequestBody Spit spit) {
        spitService.update(spit);
        return Result.success();
    }

    @DeleteMapping("{spitId}")
    public Result delete(@PathVariable String spitId) {
        spitService.deleteById(spitId);
        return Result.success();
    }

    @GetMapping("comment/{parentId}/{page}/{size}")
    public Result findByParentId(@PathVariable String parentId, @PathVariable int page, @PathVariable int size) {
        Page<Spit> pageData = spitService.findByParentid(parentId, page, size);
        return Result.success(new PageResult<Spit>(pageData.getTotalElements(), pageData.getContent()));
    }

    @PutMapping("thumbup/{spitId}")
    public Result thumbup(@PathVariable String spitId) {
        // 判断当前用户是否已经点赞[暂时还没有做登录，所以把用户Id写死]
        String userId = "1";
        // 判断是否已经点赞
        if (redisTemplate.opsForValue().get("thumbup_" + userId) != null) {
            return Result.error(StatusCode.REPERROR, "请勿重复点赞");
        }
        spitService.thumbup(spitId);
        redisTemplate.opsForValue().set("thumbup_" + userId, 1);
        return Result.success();
    }
}
