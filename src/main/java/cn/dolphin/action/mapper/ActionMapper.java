package cn.dolphin.action.mapper;

import cn.dolphin.action.domain.Action;
import cn.dolphin.action.domain.ActionExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ActionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action
     *
     * @mbggenerated
     */
    int countByExample(ActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action
     *
     * @mbggenerated
     */
    int deleteByExample(ActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action
     *
     * @mbggenerated
     */
    @Delete({
        "delete from `action`",
        "where `id` = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action
     *
     * @mbggenerated
     */
    @Insert({
        "insert into `action` (`id`, `action_name`, ",
        "`status`, `created_at`, ",
        "`updated_at`)",
        "values (#{id,jdbcType=INTEGER}, #{actionName,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR}, #{createdAt,jdbcType=TIMESTAMP}, ",
        "#{updatedAt,jdbcType=TIMESTAMP})"
    })
    int insert(Action record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action
     *
     * @mbggenerated
     */
    int insertSelective(Action record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action
     *
     * @mbggenerated
     */
    List<Action> selectByExample(ActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "`id`, `action_name`, `status`, `created_at`, `updated_at`",
        "from `action`",
        "where `id` = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Action selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Action record, @Param("example") ActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Action record, @Param("example") ActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Action record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action
     *
     * @mbggenerated
     */
    @Update({
        "update `action`",
        "set `action_name` = #{actionName,jdbcType=VARCHAR},",
          "`status` = #{status,jdbcType=VARCHAR},",
          "`created_at` = #{createdAt,jdbcType=TIMESTAMP},",
          "`updated_at` = #{updatedAt,jdbcType=TIMESTAMP}",
        "where `id` = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Action record);
}