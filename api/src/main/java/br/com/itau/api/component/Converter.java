package br.com.itau.api.component;

import java.util.function.Function;

public abstract class Converter<E, D> {

    private final Function<D, E> fronDto;
    private final Function<E, D> fronEntity;

    public Converter(Function<D, E> fronDto, Function<E, D> fronEntity) {
        this.fronDto = fronDto;
        this.fronEntity = fronEntity;
    }

    public final E convertToEntity(final D dto) {
        return fronDto.apply(dto);
    }

    public final D convertToDto(final E entity) {
        return fronEntity.apply(entity);
    }
}
