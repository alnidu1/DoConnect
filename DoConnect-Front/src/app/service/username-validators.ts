import { AbstractControl, ValidationErrors } from '@angular/forms';
import { UserService } from '../service/user.service';
import { map } from 'rxjs/operators';

export function usernameValidator(userService: UserService) {
  return (control: AbstractControl) => {
    const username = control.value;

    return userService.checkUsernameExists(username).pipe(
      map((exists: boolean) => {
        if (exists) {
          return { usernameExists: true };
        }
        return null;
      })
    );
  };
}
