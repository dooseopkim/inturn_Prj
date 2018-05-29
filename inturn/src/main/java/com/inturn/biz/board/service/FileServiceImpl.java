package com.inturn.biz.board.service;

import java.sql.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inturn.biz.board.dao.FileDAO;
import com.inturn.biz.board.vo.FileGroupVO;
import com.inturn.biz.board.vo.FilesVO;

/**
 * 
 * @author 박현호
 * @version 1.0
 * @since 2018.05.29
 * @see File처리와 관련된 함수
 */
@Service("FileService")
public class FileServiceImpl implements FileService{
	@Resource(name="FileDAO")
	FileDAO dao;

	/**
	 * @param flag 임시파일인지 아닌지 확인하는 flag
	 * 게시글이 작성중이어서 임시파일인 경우에는 flag에 유저ID가 들어가고
	 * 그렇지 않고 완전히 작성된 파일인 경우에는 -1로 그 값이 들어간다.
	 */
	@Override
	public int findFileGroup(String flag) {
		return dao.findFileGroup(flag);
	}
	
	/**
	 * @param flag 위의 함수와 같은 역할을 하는 flag
	 * @param vo 파일을 저장시킬 때, 필요한 파일의 정보
	 * flag가 유저 ID인 파일그룹번호를 찾은 다음 
	 * 해당 fileGroup의 flag를 -1로,
	 * 그리고 파일을 DB에 저장해주는 함수
	 * 게시판 작성시 이 함수가 호출된다.
	 * 따라서 파일을 작성하지않은 게시판의 경우도 있기 때문에 
	 * fileGroupNum = 0인지를 체크한다.
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int insertFiles(String flag, FilesVO vo) {
		int row = 0;
		int fileGroupNum = dao.findFileGroup(flag);
		if(fileGroupNum == 0)
			row += dao.insertFileGroup(flag);
		java.util.Date udate = new java.util.Date();
		Date regDate = new Date(udate.getTime());
		vo.setFileGroupNum(dao.findFileGroup(flag));
		vo.setRegDate(regDate);
		row += dao.insertFile(vo);
		return row;
	}
	
	/**
	 * @param vo
	 * 고객상담 게시판에 작성시
	 * csBoard의 num을
	 * 해당 File이 들어있는 FileGroupNum과 매칭하여
	 * FileGroup의 고객게시판 번호를 업데이트 해주는 함수
	 */
	@Override
	public int update_CB_FileGroup(FileGroupVO vo) {
		return dao.update_CB_FileGroup(vo);
	}
	
	/**
	 * @param vo
	 * 고객상담 게시판에 작성시
	 * FreeBoard의 num을
	 * 해당 File이 들어있는 FileGroupNum과 매칭하여
	 * FileGroup의 고객게시판 번호를 업데이트 해주는 함수
	 */
	@Override
	public int update_FB_FileGroup(FileGroupVO vo) {
		return dao.update_FB_FileGroup(vo);
	}
	
	/**
	 * @param cb_num
	 * 게시판 삭제 or 수정 시 파일을 모두 지워을 경우
	 * cb_num에 해당하는 FileGroup DB를 삭제하는 함수
	 */
	@Override
	public int delete_CB_FileGroup(int cb_num) {
		return dao.delete_CB_FileGroup(cb_num);
	}
	
	/**
	 * @param fb_num
	 * 게시판 삭제 or 수정 시 파일을 모두 지워을 경우
	 * fb_num에 해당하는 FileGroup DB를 삭제하는 함수
	 */
	@Override
	public int delete_FB_FileGroup(int fb_num) {
		return dao.delete_FB_FileGroup(fb_num);
	}
	
	/**
	 * @param vo
	 * 파일의 이름, 해시값, FilGroupNum을 통해 파일 num을 가져오는 함수
	 */
	@Override
	public int findFile(FilesVO vo) {
		return dao.findFile(vo);
	}
	
	/**
	 * @param fileGroupNum
	 * fileGroupNum에 해당하는 파일을 삭제하는 함수
	 */
	@Override
	public int deleteFile(int fileGroupNum) {
		return dao.deleteFile(fileGroupNum);
	}
	
	/**
	 * @param flag
	 * 게시판작성 시 flag를 -1로 바꿔주는 함수
	 */
	@Override
	public int insertBoard(String flag) {
		return dao.insertBoard(flag);
	}
	
	/**
	 * @param fileGroupNum
	 * fileGroupNum에 해당하는 FileGroup DB을 삭제하는 함수
	 */
	@Override
	public int deleteFileGroup(int fileGroupNum) {
		return dao.deleteFileGroup(fileGroupNum);
	}
	
	/**
	 * @param flag
	 * 게시글을 작성, 수정 하다가 취소, 다른페이지로 이동 시
	 * DB에 들어가있는 파일에 관한 정보를 모두 삭제하는 함수
	 */
	@Override
	public int cancel_insertBoard(String flag) {
		int row = 0;
		int fileGroupNum = dao.findFileGroup(flag);
		row += dao.deleteFile(fileGroupNum);
		row += dao.deleteFileGroup(fileGroupNum);
		return row;
	}
}
