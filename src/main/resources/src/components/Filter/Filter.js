import React from 'react'
import Status from "./category/Status";
export default function Filter({ 
    pageNumber,
    updatePageNumber,
    updateStatus,
  }) {
    let clear = () => {
        updateStatus("");
        updatePageNumber(1);
        window.location.reload(false);
      };
  return (
    <div className="col-lg-3 col-12 mb-5">
    <div className="text-center fw-bold fs-4 mb-2">Filtros</div>
    <Status updateStatus={updateStatus} updatePageNumber={updatePageNumber}/>
    </div>
  )
}
