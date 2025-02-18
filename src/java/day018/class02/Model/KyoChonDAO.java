package java.day018.class02.Model;

import java.util.ArrayList;
import java.util.Iterator;

public class KyoChonDAO {
    private ArrayList<KyochonDTO> datas;

    // 생성자
    public KyoChonDAO() {
        datas = new ArrayList<>();
    }

    // 전체 메뉴 검색
    public ArrayList<KyochonDTO> selectAll() {
        return new ArrayList<>(datas);
    }

    // 단일 메뉴 검색
    public ArrayList<KyochonDTO> selectOne(String menuName) {
        ArrayList<KyochonDTO> result = new ArrayList<>();
        for (KyochonDTO menu : datas) {
            if (menu.getMenuName().contains(menuName)) {
                result.add(menu);
            }
        }
        return result;
    }

    // 새로운 메뉴 추가
    public void insert(KyochonDTO dto) {
        datas.add(dto);
    }

    // 메뉴 정보 수정
    public void update(KyochonDTO dto) {
        for (int i = 0; i < datas.size(); i++) {
            if (datas.get(i).getMenuName().equals(dto.getMenuName())) {
                datas.set(i, dto);
                break;
            }
        }
    }

    // 메뉴 삭제
    public void delete(String menuName) {
        Iterator<KyochonDTO> iterator = datas.iterator();
        while (iterator.hasNext()) {
            KyochonDTO menu = iterator.next();
            if (menu.getMenuName().equals(menuName)) {
                iterator.remove();
            }
        }
    }
}
