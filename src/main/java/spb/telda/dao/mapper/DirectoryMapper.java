package spb.telda.dao.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import spb.telda.dao.entity.Directory;

import java.util.List;

/**
 * Репозиторий для работы с bd через Mybatis
 */
@Mapper
@Repository
public interface DirectoryMapper {

    /**
     * Вызывает список регионов.
     * @return
     */
    @Select("select * from directory")
    List<Directory> getAllDirectory();

    /**
     * Вызывает конкретный регион по колонке id
     * @param id
     * @return
     */
    @Select("select * from directory where id = #{id}")
    Directory getDirectoryId (@Param("id") String id);

    /**
     * Добавляет новый регион.
     * @param directory
     * @return
     */
    @Insert(value = "insert into directory values(#{id},#{regionIdentifier},#{name},#{shortName})")
    boolean addDirectory(Directory directory);

    /**
     * Удаляет выбранный регион по id
     * @param id
     * @return
     */
    @Delete("delete from directory where Id = #{id}")
    boolean deleteDirectory(@Param("id") String id);

    /**
     * Изменяет регион по id
     * @param directory
     * @return
     */
    @Update("update directory set regionIdentifier=#{regionIdentifier},name=#{name}, shortName = #{shortName} where id = #{id}")
    boolean updateDirectory(Directory directory);
}
