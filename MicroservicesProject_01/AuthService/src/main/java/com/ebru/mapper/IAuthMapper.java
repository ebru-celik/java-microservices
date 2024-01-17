package com.ebru.mapper;

import com.ebru.dto.request.DoRegisterRequestDto;
import com.ebru.dto.request.UserProfileSaveRequestDto;
import com.ebru.model.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAuthMapper {
    IAuthMapper INSTANCE = Mappers.getMapper(IAuthMapper.class);
    Auth toAuth(final DoRegisterRequestDto dto);

    /*
    @Mappings({
            @Mapping(target = "firstname", source = "fname"),
            @Mapping(target = "lastname", source = "lname")
    })
    */
    // kaynaktaki id yi cevirirken authId adina cevir
    @Mapping(target = "authId", source = "id")
    UserProfileSaveRequestDto toDto (final Auth auth);

}
