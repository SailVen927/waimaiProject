package waimai.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import waimai.entity.Image;
import waimai.service.ImageService;
import org.springframework.web.bind.annotation.*;
import waimai.utils.ResponseData;

import javax.annotation.Resource;

/**
 * (Image)表控制层
 *
 * @author makejava
 * @since 2021-08-20 16:57:49
 */
@Api(tags = "图片接口")
@RestController
@RequestMapping("image")
public class ImageController {
    /**
     * 服务对象
     */
    @Resource
    private ImageService imageService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据图片编号返回图片")
    @GetMapping("selectOne")
    public Image selectOne(Long id) {
        return this.imageService.queryById(id);
    }

    @ApiOperation(value = "根据图片类型返回图片")
    @GetMapping("queryByType")
    public ResponseData queryByType(String type){
        return this.imageService.queryByType(type);
    }
}
