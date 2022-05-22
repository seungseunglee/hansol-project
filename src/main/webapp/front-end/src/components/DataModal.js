import {Button, Stack, Box, Modal, Typography, TextField, Grid} from '@mui/material';

const DataModal = (props) => {

    const style = {
        position: 'absolute',
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        width: 400,
        bgcolor: 'background.paper',
        border: '6px solid #2196f3',
        borderRadius: '40px',
        boxShadow: 24,
        p: 8,
        alignItems: 'center'
    };

    return (
        <>
            <Modal
                open={props.open}
                onClose={props.handleClose}
                aria-labelledby="modal-modal-title"
                aria-describedby="modal-modal-description"
            >
                <Box sx={style} component="form" noValidate autoComplete='off'>
                    <Grid container justifyContent="center">
                        <Typography id="modal-modal-title" component="h2" variant="h5">사원 정보 {props.title}</Typography>
                    </Grid>
                    <br/>
                    <Stack spacing={1}>
                        <TextField required id="outlined-required" label="업무코드" onChange={e => { props.setWorkCode(e.target.value) }} defaultValue={props.workCode} />
                        <TextField required id="outlined-required" label="업무명" onChange={e => { props.setWorkName(e.target.value) }} defaultValue={props.workName}/>
                        <TextField required id="outlined-required" label="회사" onChange={e => { props.setCompany(e.target.value) }} defaultValue={props.company}/>
                        <TextField required id="outlined-required" label="담당자" onChange={e => { props.setEmpName(e.target.value) }} defaultValue={props.empName}/>
                        <TextField required id="outlined-required" label="직급" onChange={e => { props.setPosition(e.target.value) }} defaultValue={props.position}/>
                        <TextField id="outlined-multiline-flexible" label="종류" multiline maxRows={4} onChange={e => { props.setTask(e.target.value) }} defaultValue={props.task}/>
                        <TextField required id="outlined-required" label="전화번호" onChange={e => { props.setTelephone(e.target.value) }} defaultValue={props.telephone}/>
                    </Stack>
                    <br/>
                    <Grid container justifyContent="flex-end">
                        <Stack spacing={2} direction="row">
                            <Button variant="contained" onClick={props.handleData}>{props.title}</Button>
                            <Button variant="outlined" onClick={props.handleClose}>취소</Button>
                        </Stack>
                    </Grid>
                </Box>
            </Modal>
        </>
    )
}

export default DataModal;