package com.demo.service;

import com.demo.domain.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UsersService {
    /**
     * 添加
     *
     * @param users
     * @return
     */
    public boolean insert(Users users);

    /**
     * 修改数据
     *
     * @param users
     * @return
     */
    public boolean update(Users users);

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    public boolean delete(String id);

    /**
     * @param loginIds
     * @return
     */
    public boolean deletes(String[] loginIds);

    /**
     * 查询全部
     *
     * @return
     */
    public List<Users> selectAll();

    /**
     * 添根据id查询数据
     *
     * @param id
     * @return
     */
    public Users selectById(String id);

    /**
     * @param start
     * @param pageSize
     * @return
     */
    public List<Users> selectByPage(int start, int pageSize);

    /**
     * @param nickName
     * @return
     */
    public List<Users> selectByNickName(String nickName);

    /**
     * @param loginId
     * @param nickName
     * @param start
     * @param pageSize
     * @return
     */
    public List<Users> selectByIdAndNickNameAndPage(String loginId, String nickName, int start, int pageSize);

    /**
     * @param loginId
     * @param nickName
     * @return
     */
    public int getCount(String loginId, String nickName);
}
