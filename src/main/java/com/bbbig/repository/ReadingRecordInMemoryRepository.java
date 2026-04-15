package com.bbbig.repository;

import com.bbbig.model.ReadingRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ReadingRecordInMemoryRepository implements ReadingRecordRepository {

    /**
     * 독서 기록을 저장하는 인메모리 저장소 (key: 독서 기록 ID, value: 독서 기록 객체)
     */
    private final Map<Long, ReadingRecord> store = new HashMap<>();

    /**
     * 독서 기록이 생성되는 순서이자, 각 독서기록 객체의 ID가 된다. save() 호출을 통해 새로운 독서기록 저장 시 sequence가 1씩 증가하며 새 ID를 부여한다.
     */
    private Long sequence = 0L;

    /**
     * 독서 기록을 저장한다. ID가 없는 경우 sequence를 증가시켜 새 ID를 부여하고 저장한다. ID가 이미 존재하는 경우 해당 ID로 덮어쓴다. (수정)
     *
     * @param record 저장할 독서 기록 객체
     * @return ID가 부여된 독서 기록 객체
     */
    @Override
    public ReadingRecord save(ReadingRecord record) {
        // TODO 영래님 PR merge (충돌 해결) 후에 아래 코드 동작 가능
//        if (record.getId() == null) {
//            record.setId(++sequence);
//        }
//        store.put(record.getId(), record);
        return record;
    }

    /**
     * 저장된 모든 독서 기록을 조회한다. store의 값을 새로운 리스트로 복사해 반환하므로 원본 데이터가 변경되지 않는다.
     *
     * @return 전체 독서 기록 리스트 (없으면 빈 리스트 반환)
     */
    @Override
    public List<ReadingRecord> findAll() {
        return new ArrayList<>(store.values());
    }

    /**
     * ID로 특정 독서 기록을 조회한다. 해당 ID의 기록이 없을 경우 Optional.empty()를 반환한다.
     *
     * @param id 조회할 독서 기록의 ID
     * @return 독서 기록 객체를 담은 Optional, 없으면 Optional.empty()
     */
    @Override
    public Optional<ReadingRecord> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    /**
     * ID로 특정 독서 기록을 삭제한다. 해당 ID의 기록이 없을 경우 아무 동작도 하지 않는다.
     *
     * @param id 삭제할 독서 기록의 ID
     */
    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }

    /**
     * 해당 ID를 가진 독서 기록의 존재 여부를 확인한다.
     *
     * @param id 존재 여부를 확인할 독서 기록의 ID
     * @return 존재하면 true, 존재하지 않으면 false
     */
    @Override
    public boolean existsById(Long id) {
        return store.containsKey(id);
    }
}