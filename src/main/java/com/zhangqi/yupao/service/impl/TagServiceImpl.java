package com.zhangqi.yupao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhangqi.yupao.model.domain.Tag;
import com.zhangqi.yupao.service.TagService;
import com.zhangqi.yupao.mapper.TagMapper;
import org.springframework.stereotype.Service;

/**
* @author zhangqi
* @description 针对表【tag(标签)】的数据库操作Service实现
* @createDate 2022-08-09 15:34:54
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

}




