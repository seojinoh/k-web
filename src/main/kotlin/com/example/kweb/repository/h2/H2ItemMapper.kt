package com.example.kweb.repository.h2

import com.example.kweb.repository.h2.model.InsertItemRequest
import com.example.kweb.repository.h2.model.ItemResult
import com.example.kweb.repository.h2.model.UpdateItemRequest
import org.apache.ibatis.annotations.*

@Mapper
interface H2ItemMapper {
    @Select("""
        SELECT *
        FROM item
        ORDER BY id DESC
    """)
    fun readAllItems(): List<ItemResult>

    @Select("""
        SELECT *
        FROM item
        WHERE
            name LIKE CONCAT('%', #{search}, '%')
            OR description LIKE CONCAT('%', #{search}, '%')
            OR category LIKE CONCAT('%', #{search}, '%')
        ORDER BY id DESC
        LIMIT #{limit}
        OFFSET #{offset}
    """)
    fun readItemWithFilter(
        @Param("limit") limit: Long,
        @Param("offset") offset: Long,
        @Param("search") search: String
    ): List<ItemResult>

    @Select("""
        SELECT *
        FROM item
        WHERE
            id = #{id}
    """)
    fun readItemById(
        @Param("id") id: Long
    ): ItemResult?

    @Insert("""
        INSERT INTO item (
            name,
            description,
            category,
            price,
            count
        )
        VALUES (
            #{request.name},
            #{request.description},
            #{request.category},
            #{request.price},
            #{request.count}
        )
    """)
    @Options(useGeneratedKeys = true, keyProperty = "request.id", keyColumn = "id")
    fun createItem(
        @Param("request") insertItemRequest: InsertItemRequest
    ): Long

    @Update("""
        UPDATE item
        SET
            description = #{request.description},
            category = #{request.category},
            price = #{request.price},
            count = #{request.count}
        WHERE
            id = #{request.id}
    """)
    fun updateItemById(
        @Param("request") updateItemRequest: UpdateItemRequest
    ): Long

    @Delete("""
        DELETE FROM item
        WHERE
            id = #{id}
    """)
    fun deleteItemById(
        @Param("id") id: Long
    ): Long
}
