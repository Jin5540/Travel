function Edit(edit,num) {
if(confirm("Do you want to edit it?")==true)
{
	
	frm.action = "/J1/edit/Edit";
	frm.method = "post";
	frm.submit();
	
}
else
{
	return;
}
}

function Delete(num1) {
if(confirm("Do you want to delete it?")==true)
{
	
	frm.action = "/J1/delete/Delete";
	frm.method = "post";
	frm.submit();
	
}
else
{
	return;
}
}

function DeleteAll() {
if(confirm("Do you want to delete them all?")==true)
{
	 location.href = "/J1/delete/DeleteAll";
	
	
}
else
{
	return;
}
}