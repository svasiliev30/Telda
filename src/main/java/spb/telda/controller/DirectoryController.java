package spb.telda.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import spb.telda.dao.entity.Directory;
import spb.telda.dao.mapper.DirectoryMapper;


import java.util.List;

@RestController
@RequestMapping("/directory")
public class DirectoryController {

    /**
     * Репозиторий
     */
    private DirectoryMapper directoryMapper;

    /**
     * Номер в таблице(id)
     */
    private String number;

    /**
     * Вызываем репозиторий
     * @param directoryMapper
     */
    @Autowired
    public DirectoryController(DirectoryMapper directoryMapper) {
        this.directoryMapper = directoryMapper;
    }

    /**
     * Вызываем список городов.
     * @return
     */
    @GetMapping("/getAllDirectory")
    public List<Directory> getAllDirectory(){

        return directoryMapper.getAllDirectory();
    }

    /**
     * Вызываем конкретный город по колонке id.
     * @param id
     * @return
     */
    @GetMapping("/getDirectoryId/{id}")
    public Directory getDirectoryId( @PathVariable(value = "id") String id) {

        this.number = id;
        return directoryMapper.getDirectoryId(number);
    }

    /**
     * Добавляем новый регион
     * @param directory
     * @return
     */
    @PostMapping("/addDirectory")
    @ResponseStatus(HttpStatus.CREATED)
    public String addDirectory(@RequestBody Directory directory){

        directoryMapper.addDirectory(directory);
        Boolean result = directoryMapper.addDirectory(directory);
        if (result.equals(true)){
            return "region added";
        }else {
            return "this region is not added";
        }
    }

    /**
     * Удаляем выбранный регион по полю id
     * @param id
     * @return
     */
    @DeleteMapping("/deleteDirectory")
    public String deleteDirectory(@RequestParam (name = "id") String id){

        this.number = id;
        Boolean result = directoryMapper.deleteDirectory(number);
        if (result.equals(true)){
            return "successful removal";
        }else {
            return "this id is not in the table";
        }
    }

    /**
     * Изменяем конкретный данные по региону на новые
     * @param directory
     * @return
     */
    @PutMapping("/updateDirectory")
    public String updateDirectory(@RequestBody Directory directory){

        Boolean result = directoryMapper.updateDirectory(directory);
        System.out.println(directory.toString());
        if (result.equals(true)){
            return "successful has changed";
        }else {
            return "not successfully changed";
        }
    }
}
