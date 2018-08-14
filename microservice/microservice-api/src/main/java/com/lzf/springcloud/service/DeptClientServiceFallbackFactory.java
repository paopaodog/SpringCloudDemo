package com.lzf.springcloud.service;

import com.lzf.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClintService> {
    @Override
    public DeptClintService create(Throwable throwable) {
        return new DeptClintService() {
            @Override
            public Dept get(long id) {
                return new Dept().setDeptno(id).setDname("没有该记录");
            }

            @Override
            public List<Dept> list() {
                return new ArrayList<>();
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
